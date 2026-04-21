package com.twkim.samplekmp.auth.domain

import com.twkim.samplekmp.auth.api.AuthApi
import com.twkim.samplekmp.auth.data.AuthRepository

class LoginUseCase(
    private val authApi: AuthApi,
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Boolean {
        val result = authApi.login(email, password)
        authRepository.saveTokens(result.accessToken, result.refreshToken)
        return true
    }
}