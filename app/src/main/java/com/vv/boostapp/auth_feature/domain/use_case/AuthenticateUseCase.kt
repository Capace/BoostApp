package com.vv.boostapp.auth_feature.domain.use_case

import com.vv.boostapp.auth_feature.domain.AuthRepository
import com.vv.boostapp.util.SimpleResource
import javax.inject.Inject

class AuthenticateUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): SimpleResource
    {
        return repository.authenticate()
    }
}