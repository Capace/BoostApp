package com.vv.boostapp.auth_feature.data.remote.request

data class CreateAccountRequest(
    val email: String,
    val username: String,
    val password: String
)