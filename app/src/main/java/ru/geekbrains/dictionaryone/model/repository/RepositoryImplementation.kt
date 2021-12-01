package ru.geekbrains.dictionaryone.model.repository

import ru.geekbrains.dictionaryone.model.data.DataModel
import ru.geekbrains.dictionaryone.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}