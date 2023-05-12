package dev.musicapp.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.musicapp.mediaPlayer.MediaPlayerController
import dev.musicapp.ui.auth.AuthScreen
import dev.musicapp.ui.home.HomeLargeScreen
import dev.musicapp.ui.home.HomeScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
fun AppNavigation(
    showLargeScreenUi: Boolean = false,
    isUserLoggedIn: Boolean = true,
    mediaPlayerController: MediaPlayerController,
) {
    val navigator = rememberNavigator()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navigator = navigator,
        initialRoute = (if (isUserLoggedIn) AppNavScreen.HomeScreen else AppNavScreen.AuthScreen).route,
        navTransition = NavTransition(
            createTransition = fadeIn(),
            destroyTransition = fadeOut(),
            resumeTransition = fadeIn(),
            pauseTransition = fadeOut(),
        ),
    ) {
        scene(route = AppNavScreen.AuthScreen.route) {
            AuthScreen()
        }

        scene(route = AppNavScreen.HomeScreen.route) {
            if (showLargeScreenUi) {
                HomeLargeScreen(mediaPlayerController = mediaPlayerController)
            } else {
                HomeScreen(mediaPlayerController = mediaPlayerController)
            }
        }
    }
}
