package ru.geekbrains.dictionaryone.model.repository

import io.reactivex.Observable
import ru.geekbrains.dictionaryone.model.data.DataModel
import ru.geekbrains.dictionaryone.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}