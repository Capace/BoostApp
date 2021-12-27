package com.vv.boostapp.ui.play_screens.questions_screen

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vv.boostapp.ui.play_screens.components.AnswersFrame
import com.vv.boostapp.ui.play_screens.components.CustomAnimationSlide
import com.vv.boostapp.ui.play_screens.components.FinalScoreBox
import com.vv.boostapp.ui.play_screens.components.QuestionTextBox
import com.vv.boostapp.ui.theme.DarkGrayVariant
import com.vv.boostapp.util.Constants
import kotlinx.coroutines.delay

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun QuestionsScreen(
    navController: NavController,
    viewModel: QuestionsViewModel = hiltViewModel()
) {


    val questionState = viewModel.questionState.collectAsState()
    val answers = viewModel.userAnswer

    var index = remember {
        mutableStateOf(0)
    }
    val imageIndex = Images.images[index.value]
    var score by remember { mutableStateOf(0.00) }
    var time by remember {
        mutableStateOf(Constants.INITIAL_TIME)
    }
    var color = remember { mutableStateOf(DarkGrayVariant) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Constants.mediumClip))
            .padding(Constants.mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        questionState.value.questions?.let { questions ->

            var selected by remember {
                mutableStateOf(false)
            }
            color.value = questionState.value.color.let{
                it!!
            }
            if (index.value < questions.count()) {

                //SCORE
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    Text(text = "Score: ")
                    questionState.value.color?.let {
                        CustomAnimationSlide(count = String.format("%.2f", score).toDouble(), color = it, fontSize = 32)
                    }

                    Text(text =String.format("%.1f", time))
                    LaunchedEffect(key1 = time) {
                        if (time > 0.1) {
                            delay(100L)
                            time -= 0.11
                        }else time = 0.0
                    }
                }

                questionState.value.color?.let {
                    QuestionTextBox(
                        text = questions[index.value].question,
                        textColor = it
                    )
                }
                Spacer(modifier = Modifier.height(Constants.mediumHeight))
                questions[index.value].answers.forEachIndexed { i, option ->
                    AnswersFrame(
                        answer = option,
                        //questionNumber = questions[index.value].number,
                        onAnswered = {
                            println(color.value)
                            if (questions[index.value].correctAnswer == i) {
                                score += time*2
                                index.value += 1
                                selected = !selected
                            } else {
                                score -= time * 3
                                index.value += 1
                                selected = !selected
                            }
                            time = Constants.INITIAL_TIME
                        },
                    pressedColor = color.value)
                    Spacer(modifier = Modifier.height(Constants.mediumHeight))

                }

                Spacer(modifier = Modifier.height(24.dp))

                Image(painter = painterResource(id = imageIndex), contentDescription = "buddha")

            } else {
                FinalScoreBox(text = "Scor final: ", score = score)
            }
        }
        if (questionState.value.questions.isNullOrEmpty()) {
            Text(text = "NU AM GASIT INTREBARI")
        }
        Text(text = questionState.value.error)
    }
}


