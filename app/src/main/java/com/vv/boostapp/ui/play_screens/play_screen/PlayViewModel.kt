package com.vv.boostapp.ui.play_screens.play_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vv.boostapp.util.Constants
import javax.inject.Inject

class PlayViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var path = ""
    init {
        savedStateHandle.get<String>(Constants.PATH)?.let {
             path = it
        }
    }

}