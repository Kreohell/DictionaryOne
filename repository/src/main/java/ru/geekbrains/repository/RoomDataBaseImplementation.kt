package ru.geekbrains.repository


import ru.geekbrains.model.data.AppState
import ru.geekbrains.model.data.dto.SearchResultDto
import ru.geekbrains.model.data.userdata.DataModel
import ru.geekbrains.repository.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}