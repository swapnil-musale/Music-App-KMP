package dev.musicapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberAsyncImagePainter
import dev.musicapp.domain.model.AudioItem

@Composable
fun MusicItemCard(
    item: AudioItem,
    isBuffering: Boolean,
    isCurrentlyPlaying: Boolean,
    onItemClicked: (AudioItem) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 6.dp)
            .clip(shape = RoundedCornerShape(size = 16.dp))
            .clickable { onItemClicked(item) }
            .fillMaxWidth()
            .background(Color(color = 0xFF917FB3))
            .padding(all = 16.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberAsyncImagePainter(url = item.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(size = 5.dp))
                    .width(width = 40.dp)
                    .height(height = 40.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(start = 8.dp)
                    .align(alignment = Alignment.Top),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.subtitle1.copy(color = Color(color = 0XFFEFEEE0)),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = item.artists,
                    style = MaterialTheme.typography.caption.copy(color = Color(color = 0XFFEFEEE0)),
                    modifier = Modifier.padding(top = 0.dp),
                )
            }

            if (isCurrentlyPlaying && isBuffering) {
                CircularProgressIndicator(
                    modifier = Modifier.size(size = 30.dp),
                    color = Color.White,
                )
            } else {
                Text(
                    text = if (isCurrentlyPlaying) "Playing" else item.duration,
                    style = MaterialTheme.typography.caption.copy(color = Color(0XFFEFEEE0)),
                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
