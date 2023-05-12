package dev.musicapp.domain.model

data class AudioItem(
    val mediaFileUrl: String,
    val imageUrl: String,
    val artists: String,
    val title: String,
    val duration: String,
)
