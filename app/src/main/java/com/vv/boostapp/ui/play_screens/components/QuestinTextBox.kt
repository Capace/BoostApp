package com.vv.boostapp.ui.play_screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun QuestionTextBox(
    text: String,
    textColor: Color = MaterialTheme.colors.primary,
) {

    Box(
        modifier = Modifier.fillMaxHeight(0.3f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
    }

}