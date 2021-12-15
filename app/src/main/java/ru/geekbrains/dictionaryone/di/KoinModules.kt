package ru.geekbrains.dictionaryone.di

import androidx.room.Room
import org.koin.dsl.module
import ru.geekbrains.dictionaryone.view.main.MainInteractor
import ru.geekbrains.dictionaryone.view.main.MainViewModel
import ru.geekbrains.historyscreen.view.HistoryInteractor
import ru.geekbrains.historyscreen.view.HistoryViewModel
import ru.geekbrains.model.data.DataModel
import ru.geekbrains.repository.*
import ru.geekbrains.repository.room.HistoryDataBase

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}