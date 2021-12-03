package com.vv.boostapp.di

import android.content.SharedPreferences
import com.vv.boostapp.auth_feature.data.remote.AuthApi
import com.vv.boostapp.auth_feature.data.repository.AuthRepositoryImpl
import com.vv.boostapp.auth_feature.domain.AuthRepository
import com.vv.boostapp.auth_feature.domain.use_case.AuthenticateUseCase
import com.vv.boostapp.auth_feature.domain.use_case.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModule {


    @Provides
    @Singleton
    fun provideAuthApi(client: OkHttpClient): AuthApi{

        return Retrofit.Builder()
            .baseUrl(AuthApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthRepository(api: AuthApi, sharedPreferences: SharedPreferences): AuthRepository{
        return AuthRepositoryImpl(api, sharedPreferences)
    }

    @Singleton
    @Provides
    fun provideRegisterUseCase(repository: AuthRepository): RegisterUseCase{
        return RegisterUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideAuthenticateUseCase(repository: AuthRepository): AuthenticateUseCase{
        return AuthenticateUseCase(repository = repository)
    }


}