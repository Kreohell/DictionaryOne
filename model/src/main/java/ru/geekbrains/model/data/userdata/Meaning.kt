package ru.geekbrains.model.data.userdata

import com.google.gson.annotations.SerializedName

data class Meaning(
    val translatedMeaning: TranslatedMeaning = TranslatedMeaning(),
    val imageUrl: String = ""
)