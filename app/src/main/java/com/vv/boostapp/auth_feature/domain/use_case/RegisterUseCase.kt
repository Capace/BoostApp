package com.vv.boostapp.auth_feature.domain.use_case

import com.vv.boostapp.auth_feature.domain.AuthRepository
import com.vv.boostapp.auth_feature.domain.models.RegisterResult
import com.vv.boostapp.auth_feature.util.ValidateAuth
import com.vv.boostapp.util.SimpleResource
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email: String,
        username: String,
        password: String
    ): RegisterResult {

        val emailError =ValidateAuth.validateEmail(email = email)
        val usernameError = ValidateAuth.validateUsername(username = username)
        val passwordError = ValidateAuth.validatePassword(password = password)

        if(emailError != null || usernameError != null || passwordError != null){
            return RegisterResult(
                emailError = emailError,
                usernameError = usernameError,
                passwordError = passwordError
            )
        }
        val result = repository.register(email = email.trim(), username = username.trim(), password = password.trim())

        return RegisterResult(
            result = result
        )


    }
}