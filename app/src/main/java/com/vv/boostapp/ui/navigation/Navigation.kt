package com.vv.boostapp.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vv.boostapp.auth_feature.presentation.register.RegisterScreen
import com.vv.boostapp.ui.login_screen.LoginScreen
import com.vv.boostapp.ui.main_screen.MainScreen
import com.vv.boostapp.ui.play_screen.PlayScreen
import com.vv.boostapp.ui.play_screen.QuestionsScreen
import com.vv.boostapp.ui.profile_screen.ProfileScreen
import com.vv.boostapp.ui.select_screen.SelectScreen
import com.vv.boostapp.ui.splash_screen.SplashScreen

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
) {


    NavHost(navController = navController, startDestination = NavRoutes.ProfileScreen.route) {
        composable(NavRoutes.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(NavRoutes.SelectScreen.route) {
            SelectScreen(navController)
        }
        composable(NavRoutes.ProfileScreen.route) {
            ProfileScreen()
        }
        composable(NavRoutes.AboutScreen.route) {

        }
/*        composable(NavRoutes.ProfileScreen.route) {
            ProfileScreen(navController)
        }*/
        composable(NavRoutes.SplashScreen.route) {
            SplashScreen(
                navController = navController
            )
        }
        composable(NavRoutes.LoginScreen.route) {
            LoginScreen(navController, scaffoldState = scaffoldState)
        }
        composable(NavRoutes.RegisterScreen.route) {
            RegisterScreen(navController, scaffoldState = scaffoldState)
        }
        composable(NavRoutes.PlayScreen.route + "/{selectedPath}",
            listOf(navArgument("selectedPath") {
                type = NavType.StringType
                nullable = true
            }
            )) {
            PlayScreen(navController)
        }
        composable(NavRoutes.QuestionsScreen.route + "/{selectedPath}" + "/{selectedStyle}",
            listOf(navArgument("selectedPath") {
                type = NavType.StringType
                nullable = true
            }, navArgument("selectedStyle") {
                type = NavType.StringType
                nullable = true
            }
            )
        ) {
            QuestionsScreen(
                navController = navController,
                selectedPath = it.arguments?.getString("selectedStyle")
            )
        }
    }
}