package ru.geekbrains.dictionaryone.di

import androidx.room.Room
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.geekbrains.dictionaryone.view.main.MainActivity
import ru.geekbrains.dictionaryone.view.main.MainInteractor
import ru.geekbrains.dictionaryone.view.main.MainViewModel
import ru.geekbrains.historyscreen.view.HistoryActivity
import ru.geekbrains.historyscreen.view.HistoryInteractor
import ru.geekbrains.historyscreen.view.HistoryViewModel
import ru.geekbrains.model.data.dto.SearchResultDto
import ru.geekbrains.repository.*
import ru.geekbrains.repository.room.HistoryDataBase

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}