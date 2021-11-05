package com.vv.boostapp.ui.play_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.vv.boostapp.ui.theme.GrayVariant
import com.vv.boostapp.util.Constants

@Composable
fun AnswersFrame(
    bgColor: Color = GrayVariant,
    onTextColor : Color = MaterialTheme.colors.onBackground,
    answer : String,
    onAnswered: () -> Unit
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(Constants.smallPadding)
        .clip(CutCornerShape(Constants.largeClip))
        .background(bgColor),
        contentAlignment = Alignment.Center
    ){
        TextButton(onClick = { onAnswered() }) {
            Text(
                text = answer,
                color = onTextColor,
                style = MaterialTheme.typography.body1,
                fontSize = Constants.mediumFont,
                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }

    }

}