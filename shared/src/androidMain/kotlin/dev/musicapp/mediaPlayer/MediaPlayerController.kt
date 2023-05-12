package dev.musicapp.mediaPlayer

import android.media.MediaPlayer
import android.net.Uri

actual class MediaPlayerController {

    private var mediaUri: Uri? = null
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var mediaPlayerListener: MediaPlayerListener
    private var mediaUrl: String? = null

    private var isSurfaceReady = false
        set(value) {
            field = value
            if (value.and(isMediaPlayerReady)) {
                onReady()
            }
        }

    private var isMediaPlayerReady = false
        set(value) {
            field = value
            if (value.and(isSurfaceReady)) {
                onReady()
            }
        }

    private fun onReady() {
        mediaPlayerListener.onMediaPlaybackReady()
    }

    actual fun isPlaying(): Boolean {
        return try {
            mediaPlayer?.isPlaying ?: false
        } catch (e: IllegalStateException) {
            false
        }
    }

    actual fun getMediaUrl(): String? {
        return mediaUrl
    }

    actual fun prepare(mediaFile: String, listener: MediaPlayerListener) {
        if (isPlaying()) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }

        mediaPlayerListener = listener
        mediaUrl = mediaFile
        mediaUri = Uri.parse(mediaFile)

        mediaPlayer = MediaPlayer().apply {
            setOnCompletionListener {
                mediaPlayerListener.onMediaPlaybackCompleted()
            }
            setOnPreparedListener {
                mediaPlayerListener.onMediaPlaybackReady()
            }
            setOnErrorListener { mediaPlayer, i, i2 ->
                mediaPlayerListener.onMediaPlaybackError()
                mediaPlayer.release()
                true
            }
        }

        mediaPlayer?.setDataSource(mediaFile)
        mediaPlayer?.prepareAsync()
    }

    actual fun start() {
        mediaPlayer?.start()
    }

    actual fun pause() {
        mediaPlayer?.let { mediaPlayer ->
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }
    }

    actual fun stop() {
        mediaPlayer?.stop()
    }

    actual fun release() {
        isMediaPlayerReady = false
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
