package com.vv.boostapp.auth_feature.domain.models

import com.vv.boostapp.util.SimpleResource

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
