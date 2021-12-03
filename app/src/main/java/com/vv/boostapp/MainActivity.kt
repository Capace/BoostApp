package com.vv.boostapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vv.boostapp.ui.components.CustomScaffold
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.ui.navigation.Navigation
import com.vv.boostapp.ui.theme.BoostAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this, R.color.dark_gray)
            BoostAppTheme {

                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {

                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val scaffoldState = rememberScaffoldState()
                    CustomScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            NavRoutes.MainScreen.route,
                            NavRoutes.ProfileScreen.route,
                            NavRoutes.PlayScreen.route,
                            NavRoutes.SelectScreen.route
                        ),
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState
                    )
                    {
                        Navigation(navController = navController, scaffoldState = scaffoldState)
                    }
                }

            }
        }
    }
}
