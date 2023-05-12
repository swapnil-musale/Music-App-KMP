package dev.musicapp.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(modules = getSharedModule())
    }
}
