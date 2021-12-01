package com.vv.boostapp.ui.login_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vv.boostapp.auth_feature.presentation.login.LoginViewModel
import com.vv.boostapp.ui.components.StandardTextField
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.util.Constants

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.fillMaxSize()) {



    }
    Column() {

    }
    Column(
        modifier = Modifier
            .padding(Constants.largePadding)
            .fillMaxHeight(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
            Text(text = "Boost", color = MaterialTheme.colors.primary, style = MaterialTheme.typography.h4)
        }

        Spacer(modifier = Modifier.height(Constants.mediumHeight))

        StandardTextField(
            text = viewModel.usernameText.value,
            onvalueChange = { viewModel.setUsername(it) },
            hint = "Username"
        )

        StandardTextField(
            text = viewModel.passwordText.value,
            onvalueChange = { viewModel.setPasswordText(it) },
            hint = "Password"
        )

        TextButton(
            onClick = { navController.navigate(NavRoutes.MainScreen.route) },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
        ) {

            Text(text = "Login", color = MaterialTheme.colors.onPrimary)

        }
        Spacer(modifier = Modifier.heightIn(Constants.mediumHeight))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Register", color = MaterialTheme.colors.primary, modifier = Modifier.clickable { navController.navigate(NavRoutes.RegisterScreen.route) })
            Text(text = "Forgot password?", color = MaterialTheme.colors.primary, modifier = Modifier.clickable { navController.navigate(NavRoutes.MainScreen.route) })

        }


    }


}