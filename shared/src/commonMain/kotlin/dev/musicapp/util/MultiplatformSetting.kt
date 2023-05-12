package dev.musicapp.util

import com.russhwolf.settings.ObservableSettings

expect class MultiplatformSetting {
    fun provideSettings(): ObservableSettings
}
