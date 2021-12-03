package com.vv.boostapp.auth_feature.data.remote

import com.vv.boostapp.auth_feature.data.remote.request.CreateAccountRequest
import com.vv.boostapp.auth_feature.data.remote.request.LoginRequest
import com.vv.boostapp.auth_feature.data.remote.response.AuthResponse
import com.vv.boostapp.util.BasicApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("/user/create")
    suspend fun register(
        @Body request: CreateAccountRequest
    ): BasicApiResponse<Unit>

    @POST("/user/login")
    suspend fun login(
        @Body request: LoginRequest
    ): BasicApiResponse<AuthResponse>

    @GET("/user/authenticate")
    suspend fun authenticate()

    companion object {
        const val BASE_URL = "http://192.168.0.236:8080/"
    }
}