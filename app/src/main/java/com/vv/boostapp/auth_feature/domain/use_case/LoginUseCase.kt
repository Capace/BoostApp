package com.vv.boostapp.auth_feature.domain.use_case

import com.vv.boostapp.auth_feature.domain.AuthRepository
import com.vv.boostapp.auth_feature.domain.models.AuthError
import com.vv.boostapp.auth_feature.domain.models.LoginResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String): LoginResult {

        val emailError = if (email.isEmpty()) AuthError.FieldEmpty else null
        val passwordError = if (password.isEmpty()) AuthError.FieldEmpty else null

        return if (emailError != null || passwordError != null) LoginResult(
            emailError = emailError,
            passwordError = passwordError
        )
        else LoginResult(result = repository.login(email = email, password = password))

    }
}