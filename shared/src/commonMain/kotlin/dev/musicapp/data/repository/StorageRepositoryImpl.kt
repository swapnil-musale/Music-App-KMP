package dev.musicapp.data.repository

import dev.musicapp.domain.repository.StorageRepository
import dev.musicapp.util.PreferenceManager
import kotlinx.coroutines.flow.Flow

class StorageRepositoryImpl(private val preferenceManager: PreferenceManager) : StorageRepository {

    override fun getAccessToken(): Flow<String?> {
        return preferenceManager.getStringAsFlow(key = PreferenceManager.ACCESS_TOKEN_KEY)
    }

    override fun setAccessToken(accessToken: String) {
        preferenceManager.setString(key = PreferenceManager.ACCESS_TOKEN_KEY, value = accessToken)
    }
}
