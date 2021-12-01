package com.vv.boostapp.ui.navigation

import android.annotation.SuppressLint

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
        fun createPath(selectedPath : String) = "play_screen/$selectedPath"
    }
}
