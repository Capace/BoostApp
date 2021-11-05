package com.vv.boostapp.ui.play_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vv.boostapp.source.remote.QuestionRemote
import com.vv.boostapp.ui.play_screen.use_cases.GetQuestionsUseCase
import com.vv.boostapp.util.Constants
import com.vv.boostapp.util.QuestionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase,
    private val questionRemote: QuestionRemote,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var _questionState = MutableStateFlow(QuestionState())
    val questionState: StateFlow<QuestionState> = _questionState

    private val _userAnswer = mutableListOf<Int>()
    val userAnswer: MutableList<Int> = _userAnswer

    init {
        savedStateHandle.get<String>(Constants.PATH).let {
            loadQuestions(it)
            println(it)
        }
    }

    fun loadQuestions(path: String?) = viewModelScope.launch {
        getQuestionsUseCase.getQuestions(path)
            .onStart { _questionState.value = QuestionState(isLoading = true) }
            .catch { exception ->
                _questionState.value =
                    QuestionState(error = "eroare = " + exception.localizedMessage)
            }
            .collect { _questionState.value = QuestionState(questions = it) }


        println("PATHT =  " + path)
        println(path)
    }
}