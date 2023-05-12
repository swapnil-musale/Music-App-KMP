package dev.musicapp.di

import dev.musicapp.data.repository.HomeRepositoryImpl
import dev.musicapp.data.repository.StorageRepositoryImpl
import dev.musicapp.domain.repository.HomeRepository
import dev.musicapp.domain.repository.StorageRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<StorageRepository> { StorageRepositoryImpl(preferenceManager = get()) }
    single<HomeRepository> { HomeRepositoryImpl() }
}
