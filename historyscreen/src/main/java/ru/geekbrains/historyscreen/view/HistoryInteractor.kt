package ru.geekbrains.historyscreen.view

import ru.geekbrains.dictionaryone.viewmodel.Interactor
import ru.geekbrains.model.data.AppState
import ru.geekbrains.model.data.DataModel
import ru.geekbrains.repository.Repository
import ru.geekbrains.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}