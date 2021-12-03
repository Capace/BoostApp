package com.vv.boostapp.auth_feature.domain.models

import com.vv.boostapp.util.SimpleResource

data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
