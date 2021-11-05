package com.vv.boostapp.ui.play_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vv.boostapp.ui.play_screen.components.AnswersFrame
import com.vv.boostapp.util.Constants

@Composable
fun PlayScreen(
    navController: NavController,
    selectedPath: String?,
    textColor : Color = MaterialTheme.colors.primary,
    viewModel: PlayViewModel = hiltViewModel()
) {
    val state = viewModel.questionState.collectAsState()
    val answers = viewModel.userAnswer

    var index = remember {
        mutableStateOf(0)
    }

    println(index.value)
    println(selectedPath)

    Text(text = state.value.error)


    Text(text = "Score: ")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Constants.mediumClip))
            .padding(Constants.mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        state.value.questions?.let {questions->

            Text(
                text = questions[index.value].question,
                color = textColor,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Constants.mediumHeight))
            questions[index.value].answers.forEachIndexed { i, option ->
                AnswersFrame(
                    answer = option,
                    //questionNumber = questions[index.value].number,
                    onAnswered = {
                        index.value += 1
                    } )
                Spacer(modifier = Modifier.height(Constants.mediumHeight))

            }

        }
        if(state.value.questions.isNullOrEmpty()){
            Text(text = "NU AM GASIT INTREBARI")
        }
    }


}