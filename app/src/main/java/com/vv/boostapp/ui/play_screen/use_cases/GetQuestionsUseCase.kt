package com.vv.boostapp.ui.play_screen.use_cases

import com.vv.boostapp.source.local.QuestionRepository
import com.vv.boostapp.source.remote.Question
import com.vv.boostapp.source.remote.QuestionRemote
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(
    private val questionRepository: QuestionRepository
){
    suspend fun getQuestions(path: String?) = flow {
        emit(questionRepository.allQuestions(path))
    }
}

