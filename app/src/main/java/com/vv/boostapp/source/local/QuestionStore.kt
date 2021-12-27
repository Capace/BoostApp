package com.vv.boostapp.source.local

import android.content.Context
import androidx.room.Room
import com.vv.boostapp.source.remote.Question
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

class QuestionStore @Inject constructor(
    private val database: QuestionDatabase
){

    private val questions = database.getQuestions()

    suspend fun all(): List<Question> = questions.queryAll().map { it.fromLocal() }

    //
        // questions.queryAll().map { question -> question.map { it.fromLocal() } }


    suspend fun save(questions: List<Question>){
        this.questions.nukeTable()
        this.questions.insert(questions.map { it.toLocal() })
        println("aici salvam")
    }

    suspend fun isEmpty(): Boolean = questions.count() == 0L

}

private fun Question.toLocal() = LocalQuestion(
    //value = value,
    number = number,
    question = question,
    content = content,
    answers = answers,
    correctAnswer = correctAnswer
)

private fun LocalQuestion.fromLocal() = Question(
    //value = value,
    number = number,
    question = question,
    content = content,
    answers = answers,
    correctAnswer = correctAnswer
)