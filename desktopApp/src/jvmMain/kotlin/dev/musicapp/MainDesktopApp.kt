package dev.musicapp

import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow

fun main() = application {
    PreComposeWindow(
        title = "Music App",
        onCloseRequest = ::exitApplication,
    ) {
        MainDesktopView()
    }
}
