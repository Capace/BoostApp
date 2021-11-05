package com.vv.boostapp.source.local

import com.vv.boostapp.source.remote.Question
import com.vv.boostapp.source.remote.QuestionRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val questionStore: QuestionStore,
    private val questionRemote: QuestionRemote
) {

    suspend fun allQuestions(path: String?): List<Question> = questionStore.ensureIsNotEmpty(path = path).all()

    private suspend fun QuestionStore.ensureIsNotEmpty(path: String? = null) = apply{
        if(isEmpty()){
            println("IS EMPTY")
            val questions = questionRemote.getQuestions(path)
            save(questions)
        }
        else println("NOT EMPTY")
    }
}