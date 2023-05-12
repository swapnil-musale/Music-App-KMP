package dev.musicapp

import androidx.compose.runtime.Composable
import dev.musicapp.mediaPlayer.MediaPlayerController

@Composable
fun MainAndroidView() {
    val mediaPlayerController = MediaPlayerController()
    CommonApp(mediaPlayerController = mediaPlayerController)
}
