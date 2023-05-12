package dev.musicapp.di

import dev.musicapp.data.network.MusicService
import org.koin.dsl.module

val networkModule = module {
    factory { MusicService() }
}
