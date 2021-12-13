package ru.geekbrains.dictionaryone.model.datasource

import ru.geekbrains.dictionaryone.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}