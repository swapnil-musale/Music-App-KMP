package dev.musicapp.util

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.PreferencesSettings
import java.util.prefs.Preferences

actual class MultiplatformSetting {
    actual fun provideSettings(): ObservableSettings {
        return PreferencesSettings(delegate = Preferences.userRoot())
    }
}
