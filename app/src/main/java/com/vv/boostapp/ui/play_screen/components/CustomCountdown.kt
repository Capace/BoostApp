package com.vv.boostapp.ui.play_screen.components

import androidx.compose.animation.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@ExperimentalAnimationApi
@Composable
fun CustomCountdown(
    time: Int,
    isTimerRunning: Boolean
) {

/*    AnimatedContent(targetState = time,
        transitionSpec = {
            // Compare the incoming number with the previous number.
            if (targetState > initialState) {
                // If the target number is larger, it slides up and fades in
                // while the initial (smaller) number slides up and fades out.
                slideInVertically({ height -> height }) + fadeIn() with
                        slideOutVertically({ height -> -height }) + fadeOut()
            } else {
                // If the target number is smaller, it slides down and fades in
                // while the initial number slides down and fades out.
                slideInVertically({ height -> -height }) + fadeIn() with
                        slideOutVertically({ height -> height }) + fadeOut()
            }.using(
                // Disable clipping since the faded slide-in/out should
                // be displayed out of bounds.
                SizeTransform(clip = false)
            )
        }) { targetcount ->
        Text(text = "$targetcount", color = MaterialTheme.colors.primary)
    }*/



}