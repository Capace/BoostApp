package com.vv.boostapp.auth_feature.util

import android.util.Patterns
import com.vv.boostapp.auth_feature.domain.models.AuthError
import com.vv.boostapp.util.Constants

object ValidateAuth {

    fun validateEmail(email: String): AuthError? {
        val trimmedEmail = email.trim()

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return AuthError.InvalidEmail
        }
        if(trimmedEmail.isBlank()) {
            return AuthError.FieldEmpty
        }
        return null
    }

    fun validateUsername(username: String): AuthError? {
        val trimmedUsername = username.trim()
        if(trimmedUsername.length < Constants.MIN_USERNAME_LENGTH) {
            return AuthError.InputTooShort
        }
        if(trimmedUsername.isBlank()) {
            return AuthError.FieldEmpty
        }
        return null
    }

    fun validatePassword(password: String): AuthError? {
        val capitalLettersInPassword = password.any { it.isUpperCase() }
        val numberInPassword = password.any { it.isDigit() }
        if(!capitalLettersInPassword || !numberInPassword) {
            return AuthError.InvalidPassword
        }
        if(password.length < Constants.MIN_PASS_LENGTH) {
            return AuthError.InputTooShort
        }
        if(password.isBlank()) {
            return AuthError.FieldEmpty
        }
        return null
    }
}