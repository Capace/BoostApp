package com.vv.boostapp.ui.splash_screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vv.boostapp.R
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.util.UiEvent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(
    navController: NavController,
    dispatcher : CoroutineDispatcher = Dispatchers.Main,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(6f)
    }



    LaunchedEffect(key1 = true){
        withContext(dispatcher){
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 600,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(1200)
            navController.popBackStack()
            navController.navigate(NavRoutes.LoginScreen.route)
        }
    }

    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest {
            when(it){
                is UiEvent.Navigate ->{
                    navController.popBackStack()
                    navController.navigate(it.route)
                }
            }
        }
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_spiral),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale = scale.value)
        )
    }
}