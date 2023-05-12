package dev.musicapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.musicapp.mediaPlayer.MediaPlayerController
import dev.musicapp.navigation.AppNavigation

@Composable
fun CommonApp(mediaPlayerController: MediaPlayerController) {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            AppNavigation(mediaPlayerController = mediaPlayerController)
        }
    }
}
