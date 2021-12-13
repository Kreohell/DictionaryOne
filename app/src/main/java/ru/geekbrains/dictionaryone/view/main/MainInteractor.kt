package ru.geekbrains.dictionaryone.view.main

import ru.geekbrains.dictionaryone.model.data.AppState
import ru.geekbrains.dictionaryone.model.data.DataModel
import ru.geekbrains.dictionaryone.model.repository.Repository
import ru.geekbrains.dictionaryone.viewmodel.Interactor


class MainInteractor (
   val repositoryRemote: Repository<List<DataModel>>,
   val repositoryLocal: Repository<List<DataModel>>
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