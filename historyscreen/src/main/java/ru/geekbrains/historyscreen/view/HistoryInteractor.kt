package ru.geekbrains.historyscreen.view

import ru.geekbrains.dictionaryone.viewmodel.Interactor
import ru.geekbrains.historyscreen.mapSearchResultToResult
import ru.geekbrains.model.data.AppState
import ru.geekbrains.model.data.dto.SearchResultDto
import ru.geekbrains.model.data.userdata.DataModel
import ru.geekbrains.repository.Repository
import ru.geekbrains.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}