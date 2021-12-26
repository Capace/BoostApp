package com.vv.boostapp.ui.play_screens.use_cases

import com.vv.boostapp.source.local.QuestionRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(
    private val questionRepository: QuestionRepository
){
    suspend fun getQuestions(path: String?) = flow {
        emit(questionRepository.allQuestions(path))
    }
}

