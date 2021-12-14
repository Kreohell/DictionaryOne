package ru.geekbrains.dictionaryone.model.repository

import ru.geekbrains.dictionaryone.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
