package ru.geekbrains.dictionaryone.model.datasource

import io.reactivex.Observable
import ru.geekbrains.dictionaryone.model.data.DataModel

class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}