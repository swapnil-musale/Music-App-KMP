package dev.musicapp.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val uriHandler = LocalUriHandler.current
        // TODO
        val authorizationUrl =
            "https://accounts.spotify.com/en/authorize?response_type=token&client_id=client_id&scope=user-read-private&redirect_uri=musicapp://auth_callback&state=abc"

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            onClick = {
                uriHandler.openUri(uri = authorizationUrl)
            },
        ) {
            Text(
                text = "Login with Spotify",
                modifier = Modifier.padding(vertical = 4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }
    }
}
