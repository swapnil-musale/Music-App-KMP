package dev.musicapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface StorageRepository {
    fun getAccessToken(): Flow<String?>
    fun setAccessToken(accessToken: String)
}
