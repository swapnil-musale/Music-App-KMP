package dev.musicapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.musicapp.domain.model.AudioItem
import dev.musicapp.mediaPlayer.MediaPlayerController
import dev.musicapp.mediaPlayer.MediaPlayerListener
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun HomeLargeScreen(mediaPlayerController: MediaPlayerController) {
    val homeViewModel: HomeViewModel = viewModel(
        modelClass = HomeViewModel::class,
        keys = listOf("Key"),
    ) {
        HomeViewModel()
    }

    val audioList = homeViewModel.audioList.collectAsState().value
    val selectedIndex = remember { mutableStateOf(value = -1) }
    val isBuffering = remember { mutableStateOf(false) }
    var selectedTrack by remember { mutableStateOf<AudioItem?>(null) }

    LaunchedEffect(key1 = selectedIndex.value) {
        if (selectedIndex.value != -1) {
            selectedTrack = audioList[selectedIndex.value]
        }
    }

    playMediaFileObserver(
        selectedTrack = selectedTrack,
        mediaPlayerController = mediaPlayerController,
        isBuffering = isBuffering,
        selectedIndex = selectedIndex,
        audioList = audioList,
    )

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
        ) {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(items = audioList, key = { it.title }) { item ->
                    MusicItemCard(
                        isBuffering = isBuffering.value,
                        isCurrentlyPlaying = selectedTrack == item,
                        item = item,
                        onItemClicked = {
                            if (mediaPlayerController.isPlaying() && mediaPlayerController.getMediaUrl() == it.mediaFileUrl) {
                                mediaPlayerController.pause()
                                selectedTrack = null
                            } else {
                                isBuffering.value = true
                                selectedIndex.value = audioList.indexOf(element = it)
                            }
                        },
                    )
                }
            }
        }
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            mediaPlayerController.release()
        }
    }
}

private fun playMediaFileObserver(
    selectedTrack: AudioItem?,
    mediaPlayerController: MediaPlayerController,
    isBuffering: MutableState<Boolean>,
    selectedIndex: MutableState<Int>,
    audioList: List<AudioItem>,
) {
    selectedTrack?.mediaFileUrl?.let { mediaFile ->
        mediaPlayerController.prepare(
            mediaFile = mediaFile,
            listener = object : MediaPlayerListener {
                override fun onMediaPlaybackReady() {
                    mediaPlayerController.start()
                    isBuffering.value = false
                }

                override fun onMediaPlaybackCompleted() {
                    if (selectedIndex.value < audioList.size - 1) {
                        selectedIndex.value = selectedIndex.value + 1
                    }
                }

                override fun onMediaPlaybackError() {
                    println("Error Occurred While Playing Media")
                }
            },
        )
    }
}
