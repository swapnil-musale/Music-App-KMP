package dev.musicapp.data.repository

import dev.musicapp.data.data.LocalData
import dev.musicapp.domain.model.AudioItem
import dev.musicapp.domain.repository.HomeRepository

class HomeRepositoryImpl : HomeRepository {

    override suspend fun getAllMusicList(): Result<List<AudioItem>> {
        return Result.success(value = LocalData.audioList)
    }
}
