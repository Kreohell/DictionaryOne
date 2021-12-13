package ru.geekbrains.dictionaryone.model.datasource

import io.reactivex.Observable
import ru.geekbrains.dictionaryone.model.data.AppState
import ru.geekbrains.dictionaryone.model.data.DataModel
import ru.geekbrains.dictionaryone.room.HistoryDao
import ru.geekbrains.dictionaryone.utils.convertDataModelSuccessToEntity
import ru.geekbrains.dictionaryone.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}