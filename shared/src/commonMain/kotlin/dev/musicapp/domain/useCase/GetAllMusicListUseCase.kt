package dev.musicapp.domain.useCase

import dev.musicapp.domain.repository.HomeRepository

class GetAllMusicListUseCase(private val homeRepository: HomeRepository) {
    suspend operator fun invoke() = homeRepository.getAllMusicList()
}
