package com.vv.boostapp.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "questions")
data class LocalQuestion(
    @PrimaryKey(autoGenerate = true)
    val value: Int? = null,
    val number: Int,
    val question: String,
    val content: String,
    val answers: List<String>,
    val correctAnswer : Int
)
