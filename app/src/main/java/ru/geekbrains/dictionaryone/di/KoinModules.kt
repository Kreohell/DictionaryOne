package ru.geekbrains.dictionaryone.di

import androidx.room.Room
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.geekbrains.dictionaryone.model.data.DataModel
import ru.geekbrains.dictionaryone.model.datasource.RetrofitImplementation
import ru.geekbrains.dictionaryone.model.datasource.RoomDataBaseImplementation
import ru.geekbrains.dictionaryone.model.repository.Repository
import ru.geekbrains.dictionaryone.model.repository.RepositoryImplementation
import ru.geekbrains.dictionaryone.model.repository.RepositoryImplementationLocal
import ru.geekbrains.dictionaryone.model.repository.RepositoryLocal
import ru.geekbrains.dictionaryone.room.HistoryDataBase
import ru.geekbrains.dictionaryone.view.history.HistoryInteractor
import ru.geekbrains.dictionaryone.view.history.HistoryViewModel
import ru.geekbrains.dictionaryone.view.main.MainInteractor
import ru.geekbrains.dictionaryone.view.main.MainViewModel

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