package dev.musicapp.mediaPlayer

expect class MediaPlayerController {

    fun getMediaUrl(): String?
    fun prepare(mediaFile: String, listener: MediaPlayerListener)
    fun start()
    fun pause()
    fun stop()
    fun isPlaying(): Boolean
    fun release()
}
