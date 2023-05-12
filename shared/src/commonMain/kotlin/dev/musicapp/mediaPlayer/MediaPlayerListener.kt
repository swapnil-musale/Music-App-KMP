package dev.musicapp.mediaPlayer

interface MediaPlayerListener {
    fun onMediaPlaybackReady()
    fun onMediaPlaybackCompleted()
    fun onMediaPlaybackError()
}
