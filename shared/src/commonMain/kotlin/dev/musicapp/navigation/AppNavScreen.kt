package dev.musicapp.navigation

sealed class AppNavScreen(val route: String) {
    object AuthScreen : AppNavScreen(route = "auth_screen")
    object HomeScreen : AppNavScreen(route = "home_screen")
}
