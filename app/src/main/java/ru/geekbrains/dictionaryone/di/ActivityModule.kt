package ru.geekbrains.dictionaryone.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.geekbrains.dictionaryone.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
