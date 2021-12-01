package com.vv.boostapp.auth_feature.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vv.boostapp.ui.components.StandardTextField
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.util.Constants

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = hiltViewModel()
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Boost",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h4
            )
        }

        Spacer(modifier = Modifier.height(Constants.mediumHeight))

        StandardTextField(
            text = registerViewModel.emailState.value,
            onvalueChange = { registerViewModel.onEvent(RegisterEvent.EnteredEmail(it)) },
            hint = "Email"
        )

        StandardTextField(
            text = registerViewModel.usernameState.value,
            onvalueChange = { registerViewModel.onEvent(RegisterEvent.EnteredUsername(it)) },
            hint = "Username"
        )

        StandardTextField(
            text = registerViewModel.passwordState.value,
            onvalueChange = { registerViewModel.onEvent(RegisterEvent.EnteredPassword(it)) },
            hint = "Password"
        )

        TextButton(
            onClick = { registerViewModel.onEvent(RegisterEvent.Register) },
                //navController.navigate(NavRoutes.MainScreen.route) },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                ) {
                Text(text = "Register", color = MaterialTheme.colors.onPrimary)
            }
                Spacer(modifier = Modifier.heightIn(Constants.mediumHeight))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Register",
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                NavRoutes.MainScreen.route
                            )
                        })
                    Text(
                        text = "Forgot password?",
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                NavRoutes.MainScreen.route
                            )
                        })
                }
            }
    }
