package dev.musicapp.di

import dev.musicapp.domain.useCase.GetAllMusicListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetAllMusicListUseCase(homeRepository = get()) }
}
