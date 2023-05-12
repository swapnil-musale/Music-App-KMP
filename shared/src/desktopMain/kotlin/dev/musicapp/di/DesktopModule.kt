package dev.musicapp.di

import dev.musicapp.util.MultiplatformSetting
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    factory { MultiplatformSetting() }
}
