package com.vv.boostapp.ui.play_screen.components

import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.style.TextAlign
import com.vv.boostapp.ui.theme.CardioColor
import com.vv.boostapp.ui.theme.DarkGrayVariant
import com.vv.boostapp.ui.theme.GrayVariant
import com.vv.boostapp.util.Constants
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@ExperimentalComposeUiApi
@Composable
fun AnswersFrame(
/*    bgColor: Color = GrayVariant,*/
    onTextColor: Color = MaterialTheme.colors.onBackground,
    answer: String,
    onAnswered: () -> Unit,
    pressedColor: Color = GrayVariant
) {

    var bgColor by remember { mutableStateOf(GrayVariant) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.smallPadding)
            .clip(CutCornerShape(Constants.largeClip))
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {

        Button(
            modifier = Modifier.pointerInteropFilter {
                when(it.action){
                    MotionEvent.ACTION_DOWN->{ bgColor = pressedColor; onAnswered() }
                    MotionEvent.ACTION_UP ->{ bgColor = GrayVariant }
                    else -> false
                }
                true
            },
            onClick = { onAnswered() },
            colors = ButtonDefaults.buttonColors(backgroundColor = bgColor)

        ) {
            Text(
                text = answer,
                color = onTextColor,
                style = MaterialTheme.typography.body1,
                fontSize = Constants.mediumFont,
                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
            )
        }

    }

}
