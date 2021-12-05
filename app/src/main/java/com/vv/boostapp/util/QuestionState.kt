package com.vv.boostapp.util

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.vv.boostapp.source.local.LocalQuestion
import com.vv.boostapp.source.remote.Question

data class QuestionState(
    var questions : List<Question>? = null,
    val color : Color? = null,
    val isLoading: Boolean = false,
    val error : String = "",
    val path: String? = null
)
