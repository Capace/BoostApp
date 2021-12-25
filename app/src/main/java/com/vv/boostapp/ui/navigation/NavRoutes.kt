package com.vv.boostapp.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import com.vv.boostapp.util.Constants

sealed class NavRoutes(val route :String){
    object LoginScreen: NavRoutes("login_screen")
    object RegisterScreen: NavRoutes("register_screen")
    object MainScreen : NavRoutes("main_screen")
    object SelectScreen: NavRoutes("select_screen")
    object SettingsScreen : NavRoutes("settings_screen")
    object AboutScreen : NavRoutes("about_screen")
    object ProfileScreen :NavRoutes ("profile_screen")
    @SuppressLint("CustomSplashScreen")
    object SplashScreen :NavRoutes ("splash_screen")
    object PlayScreen :NavRoutes ("play_screen"){
        fun createPath(selectedPath: String) = "play_screen/$selectedPath"
    }
    object QuestionsScreen :NavRoutes ("questions_screen"){

        fun createPath(selectedStyle : String, savedStateHandle: SavedStateHandle = SavedStateHandle()): String {
            val selectedPath = savedStateHandle.get<String>(Constants.PATH)
            return "play_screen/$selectedPath/questions_screen"
        }
    }
}
