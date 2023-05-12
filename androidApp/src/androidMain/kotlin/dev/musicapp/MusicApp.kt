package dev.musicapp

import android.app.Application
import dev.musicapp.di.getSharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MusicApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MusicApp)
            modules(modules = getSharedModule())
        }
    }
}
