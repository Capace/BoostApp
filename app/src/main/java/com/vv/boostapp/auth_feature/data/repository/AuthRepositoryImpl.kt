package com.vv.boostapp.auth_feature.data.repository

import android.content.SharedPreferences
import com.vv.boostapp.R
import com.vv.boostapp.auth_feature.data.remote.AuthApi
import com.vv.boostapp.auth_feature.data.remote.request.CreateAccountRequest
import com.vv.boostapp.auth_feature.data.remote.request.LoginRequest
import com.vv.boostapp.auth_feature.domain.AuthRepository
import com.vv.boostapp.util.Constants
import com.vv.boostapp.util.Resource
import com.vv.boostapp.util.SimpleResource
import com.vv.boostapp.util.UiText
import io.ktor.utils.io.concurrent.*
import okhttp3.internal.userAgent
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val sharedPreferences: SharedPreferences
): AuthRepository {

    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource {

        val request = CreateAccountRequest(email, username = username, password = password)
        return try{
            val response =api.register(request = request)
            if(response.successful){
                Resource.Success(Unit)
            }
            else{
                response.message?.let {msg->
                    Resource.Error(UiText.DynamicString(msg))
                }?:Resource.Error(UiText.StringResource(R.string.unkonwn_error))
            }
        }
        catch (e: IOException){
            Resource.Error(uiText = UiText.StringResource(R.string.could_not_reach_server))
        }
        catch (e: HttpException){
            Resource.Error(uiText = UiText.StringResource(R.string.something_wrong))
        }

    }

    override suspend fun login(username: String, email: String, password: String): SimpleResource {
        val request = LoginRequest(username = username, password = password)
        return try{
            val response = api.login(request = request)
            if (response.successful){
                response.data?.let {authResponse ->
                    sharedPreferences.edit()
                        .putString(Constants.KEY_JWT_TOKEN, authResponse.token)
                        .putString(Constants.KEY_USER_ID, authResponse.userId)
                        .apply()
                }
                Resource.Success(Unit)
            }
            else
            {
                response.message?.let {
                    msg-> Resource.Error(UiText.DynamicString(msg))
                }?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        }
        catch (e: IOException){
            Resource.Error(UiText.StringResource(R.string.could_not_reach_server))
        }
        catch (e: HttpException){
            Resource.Error(uiText = UiText.StringResource(R.string.something_wrong))
        }
    }

    override suspend fun authenticate(): SimpleResource {
        return try {
            api.authenticate()
            Resource.Success(Unit)
        }
        catch (e: IOException){
            Resource.Error(UiText.StringResource(R.string.could_not_reach_server))
        }
        catch (e: HttpException){
            Resource.Error(uiText = UiText.StringResource(R.string.something_wrong))
        }
    }
}