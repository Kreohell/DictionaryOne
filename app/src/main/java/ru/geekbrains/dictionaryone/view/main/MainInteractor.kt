package ru.geekbrains.dictionaryone.view.main

import io.reactivex.Observable
import ru.geekbrains.dictionaryone.di.NAME_LOCAL
import ru.geekbrains.dictionaryone.di.NAME_REMOTE
import ru.geekbrains.dictionaryone.model.data.AppState
import ru.geekbrains.dictionaryone.model.data.DataModel
import ru.geekbrains.dictionaryone.model.repository.Repository
import ru.geekbrains.dictionaryone.viewmodel.Interactor
import javax.inject.Inject
import javax.inject.Named


class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}