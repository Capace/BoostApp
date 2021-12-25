package com.vv.boostapp.ui.play_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.ui.play_screen.components.LearningStyle
import com.vv.boostapp.ui.play_screen.components.StyleContainer
import com.vv.boostapp.util.Constants

@Composable
fun PlayScreen(
    navController: NavController
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
            route = "clinical"
        )
    )


        Column() {
            Text(text = "Select learning style: ")
            Spacer(modifier = Modifier.height(24.dp))

            for (element in styles) {
                StyleContainer(onClick = { navController.navigate(NavRoutes.QuestionsScreen.createPath(element.route)) } ,element.name, element.color)
            }

        }



}