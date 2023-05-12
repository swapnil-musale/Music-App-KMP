package dev.musicapp.util

import com.russhwolf.settings.coroutines.getStringOrNullFlow
import com.russhwolf.settings.set
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PreferenceManager : KoinComponent {

    private val multiplatformSetting: MultiplatformSetting by inject()

    companion object {
        const val ACCESS_TOKEN_KEY = "access_token"
    }

    private val observableSettings = multiplatformSetting.provideSettings()

    fun getString(key: String) = observableSettings.getStringOrNull(key = key)

    fun getStringAsFlow(key: String) = observableSettings.getStringOrNullFlow(key = key)

    fun setString(key: String, value: String) {
        observableSettings.set(key = key, value = value)
    }

    fun getInt(key: String) = observableSettings.getIntOrNull(key = key)

    fun setInt(key: String, value: Int) {
        observableSettings.set(key = key, value = value)
    }
}
