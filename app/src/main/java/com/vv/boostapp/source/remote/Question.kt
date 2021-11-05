package com.vv.boostapp.source.remote

import androidx.annotation.Keep
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Question(
    @PrimaryKey(autoGenerate = true)
    val value: Int? = null,
    val number: Int,
    val question: String,
    val content: String,
    val answers: List<String>,
    val correctAnswer : Int
)
