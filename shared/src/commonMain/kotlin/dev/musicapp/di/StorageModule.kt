package dev.musicapp.di

import dev.musicapp.util.PreferenceManager
import org.koin.dsl.module

val storageModule = module {
    single { PreferenceManager() }
}
