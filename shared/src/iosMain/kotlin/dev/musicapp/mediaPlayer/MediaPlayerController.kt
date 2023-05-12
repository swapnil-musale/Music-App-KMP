package dev.musicapp.mediaPlayer

import kotlinx.cinterop.cValue
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItemDidPlayToEndTimeNotification
import platform.AVFoundation.AVPlayerTimeControlStatusPlaying
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.seekToTime
import platform.AVFoundation.timeControlStatus
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSOperationQueue
import platform.Foundation.NSURL
import platform.darwin.NSObjectProtocol
import kotlin.native.ref.WeakReference

actual class MediaPlayerController {

    private var mediaPlayerListener: WeakReference<MediaPlayerListener>? = null
    private var observer: NSObjectProtocol? = null
    private var mediaUrl: String? = null

    private var avPlayer: AVPlayer? = null
        set(value) {
            field = value
            checkReady()
        }

    private fun checkReady() {
        if (avPlayer != null) {
            onReady()
        }
    }

    actual fun prepare(mediaFile: String, listener: MediaPlayerListener) {
        mediaPlayerListener = WeakReference(listener)

        val url = NSURL(string = mediaFile)
        avPlayer = AVPlayer(uRL = url)
        mediaUrl = mediaFile

        observer = NSNotificationCenter.defaultCenter.addObserverForName(
            name = AVPlayerItemDidPlayToEndTimeNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue,
            usingBlock = {
                listener.onMediaPlaybackCompleted()
            },
        )
    }

    actual fun getMediaUrl(): String? {
        return mediaUrl
    }

    private fun onReady() {
        mediaPlayerListener?.get()?.onMediaPlaybackReady()
    }

    actual fun start() {
        avPlayer?.play()
    }

    actual fun pause() {
        avPlayer?.pause()
    }

    actual fun stop() {
        avPlayer?.run {
            pause()
            seekToTime(
                time = cValue {
                    value = 0
                },
            )
        }
    }

    actual fun isPlaying(): Boolean {
        return avPlayer?.timeControlStatus == AVPlayerTimeControlStatusPlaying
    }

    actual fun release() {
        observer?.let { NSNotificationCenter.defaultCenter.removeObserver(it) }
    }
}
