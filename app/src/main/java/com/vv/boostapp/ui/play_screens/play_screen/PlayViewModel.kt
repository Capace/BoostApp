package com.vv.boostapp.ui.play_screens.play_screen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vv.boostapp.ui.play_screens.use_cases.GetQuestionsUseCase
import com.vv.boostapp.ui.theme.CardioColor
import com.vv.boostapp.ui.theme.NephroColor
import com.vv.boostapp.ui.theme.NeuroColor
import com.vv.boostapp.ui.theme.OrangePrimary
import com.vv.boostapp.util.Constants
import com.vv.boostapp.util.QuestionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getQuestionsUseCase: GetQuestionsUseCase
): ViewModel() {



}