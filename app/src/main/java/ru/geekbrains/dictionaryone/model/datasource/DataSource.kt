package ru.geekbrains.dictionaryone.model.datasource

interface DataSource<T> {

   suspend fun getData(word: String): T
}