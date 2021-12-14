package ru.geekbrains.dictionaryone.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.geekbrains.dictionaryone.di.application
import ru.geekbrains.dictionaryone.di.historyScreen
import ru.geekbrains.dictionaryone.di.mainScreen


class DictionaryOneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}