package com.vv.boostapp.auth_feature.domain

import com.vv.boostapp.util.SimpleResource

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource

    suspend fun login(
        username: String,
        email: String,
        password: String
    ): SimpleResource

    suspend fun authenticate(): SimpleResource

}