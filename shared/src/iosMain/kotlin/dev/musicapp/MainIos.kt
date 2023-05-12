package dev.musicapp

import dev.musicapp.di.initKoin
import dev.musicapp.mediaPlayer.MediaPlayerController
import moe.tlaster.precompose.PreComposeApplication
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val mediaPlayerController = MediaPlayerController()

    initKoin()
    return PreComposeApplication(title = "") {
        CommonApp(mediaPlayerController = mediaPlayerController)
    }
}
