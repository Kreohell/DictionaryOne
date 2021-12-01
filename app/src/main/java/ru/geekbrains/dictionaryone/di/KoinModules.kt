package ru.geekbrains.dictionaryone.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.geekbrains.dictionaryone.model.data.DataModel
import ru.geekbrains.dictionaryone.model.datasource.RetrofitImplementation
import ru.geekbrains.dictionaryone.model.datasource.RoomDataBaseImplementation
import ru.geekbrains.dictionaryone.model.repository.Repository
import ru.geekbrains.dictionaryone.model.repository.RepositoryImplementation
import ru.geekbrains.dictionaryone.view.main.MainInteractor
import ru.geekbrains.dictionaryone.view.main.MainViewModel

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(RetrofitImplementation()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(RoomDataBaseImplementation()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}