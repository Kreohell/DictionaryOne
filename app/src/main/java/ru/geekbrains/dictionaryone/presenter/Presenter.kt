package ru.geekbrains.dictionaryone.presenter

import ru.geekbrains.dictionaryone.model.data.AppState
import ru.geekbrains.dictionaryone.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}