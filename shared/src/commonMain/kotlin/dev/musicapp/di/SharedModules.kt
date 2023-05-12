package dev.musicapp.di

import org.koin.core.module.Module

expect fun platformModule(): Module

val sharedModuleList = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    storageModule,
    platformModule(),
)

fun getSharedModule() = sharedModuleList
