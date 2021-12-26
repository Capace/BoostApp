package com.vv.boostapp.ui.play_screens.questions_screen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    selectedPath: String?,
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    val questionState = viewModel.questionState.collectAsState()
    val answers = viewModel.userAnswer

    var index = remember {
        mutableStateOf(0)
    }
    var score by remember { mutableStateOf(0) }
    var time by remember {
        mutableStateOf(10)
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
            println(index.value)
            println(questions.count())
            if (index.value < questions.count()) {

                //SCORE
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    Text(text = "Score: ")
                    questionState.value.color?.let {
                        CustomAnimationSlide(count = score, color = it)
                    }
                    Text(text = "time: " + time.toString())
                    LaunchedEffect(key1 = time) {
                        if (time > 0) {
                            delay(1000L)
                            time -= 1
                        }
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
                                score += time
                                index.value += 1
                                time = 10
                                selected = !selected
                            } else {
                                score -= 1
                                index.value += 1
                                time = 10
                                selected = !selected
                            }
                        },
                    pressedColor = color.value)
                    Spacer(modifier = Modifier.height(Constants.mediumHeight))

                }
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
