package dev.musicapp.domain.repository

import dev.musicapp.domain.model.AudioItem

interface HomeRepository {
    suspend fun getAllMusicList(): Result<List<AudioItem>>
}
