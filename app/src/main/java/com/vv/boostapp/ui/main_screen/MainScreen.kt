package com.vv.boostapp.ui.main_screen

import android.view.MotionEvent
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vv.boostapp.ui.theme.CardioColor
import com.vv.boostapp.ui.theme.GrayVariant
import com.vv.boostapp.ui.theme.NephroColor
import com.vv.boostapp.ui.theme.NeuroColor

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun MainScreen(navController: NavController) {


    println("screen_main = " + navController.currentDestination?.route )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
       var color by remember { mutableStateOf(NephroColor) }
        Text(text = "Welcome back!", style = MaterialTheme.typography.h4, color = MaterialTheme.colors.primary)
        /*
        Button(onClick = {
                         println(color)
        }, modifier = Modifier.pointerInteropFilter {
         when(it.action){
             MotionEvent.ACTION_DOWN-> { color = CardioColor }
             MotionEvent.ACTION_UP -> { color = NephroColor}
             else -> false
         }
         true
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = color)) {

        }*/

    }
}