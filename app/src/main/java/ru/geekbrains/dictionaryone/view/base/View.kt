package ru.geekbrains.dictionaryone.view.base

import ru.geekbrains.dictionaryone.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}