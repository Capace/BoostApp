package com.vv.boostapp.ui.play_screens.play_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.ui.play_screens.components.LearningStyle
import com.vv.boostapp.ui.play_screens.components.StyleContainer

@Composable
fun PlayScreen(
    navController: NavController,
    playViewModel: PlayViewModel = hiltViewModel()
) {

    val styles = listOf<LearningStyle>(
        LearningStyle(
            "Questions",
            Color.Red,
            route = "questions_screen"
        ),
        LearningStyle(
            "Clinical",
            Color.Blue,
            route = "clinical_screen"
        )
    )


        Column() {
            Text(text = "Select learning style: ")
            Spacer(modifier = Modifier.height(24.dp))

            for (element in styles) {
                StyleContainer(onClick = { navController.navigate(NavRoutes.QuestionsScreen.createPath(element.route, playViewModel.path)) } ,element.name, element.color)
            }

        }



}