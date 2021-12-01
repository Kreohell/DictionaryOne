package ru.geekbrains.dictionaryone.application

import android.app.Application
import org.koin.core.context.startKoin
import ru.geekbrains.dictionaryone.di.application
import ru.geekbrains.dictionaryone.di.mainScreen


class DictionaryOneApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}