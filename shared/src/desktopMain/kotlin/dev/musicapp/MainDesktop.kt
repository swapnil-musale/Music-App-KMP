package dev.musicapp

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import dev.musicapp.di.initKoin
import dev.musicapp.mediaPlayer.MediaPlayerController

@Composable
fun MainDesktopView() {
    initKoin()
    val mediaPlayerController = MediaPlayerController()
    CommonLargeApp(mediaPlayerController = mediaPlayerController)
}

@Preview
@Composable
fun AppPreview() {
    val mediaPlayerController = MediaPlayerController()
    CommonLargeApp(mediaPlayerController = mediaPlayerController)
}
