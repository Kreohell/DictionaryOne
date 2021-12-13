package ru.geekbrains.dictionaryone.model.repository

interface Repository<T> {

   suspend fun getData(word: String): T
}