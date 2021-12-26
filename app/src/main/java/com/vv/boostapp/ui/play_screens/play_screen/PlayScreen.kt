package com.vv.boostapp.ui.play_screens.play_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.ui.play_screens.components.LearningStyle
import com.vv.boostapp.ui.play_screens.components.StyleContainer
import com.vv.boostapp.ui.play_screens.questions_screen.QuestionsViewModel

@Composable
fun PlayScreen(
    navController: NavController,
    questionsViewModel: QuestionsViewModel = hiltViewModel()
) {
    if (questionsViewModel.questionState.value.color == null) {
        Box(modifier = Modifier.fillMaxWidth().padding(30.dp), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }

    } else {
        val themeColor = questionsViewModel.questionState.value.color!!
        val styles = listOf<LearningStyle>(
            LearningStyle(
                "Questions",
                themeColor,
                route = "questions_screen"
            ),
            LearningStyle(
                "Clinical",
                themeColor,
                route = "clinical_screen"
            )
        )




        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Select learning style: ",
                color = themeColor,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(24.dp))

            for (element in styles) {
                StyleContainer(onClick = {
                    navController.navigate(
                        NavRoutes.QuestionsScreen.createPath(
                            element.route,
                            questionsViewModel.path
                        )
                    )
                }, element.name, element.color)
            }
        }
    }
}