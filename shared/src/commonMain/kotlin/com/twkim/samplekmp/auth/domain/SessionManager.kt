package com.twkim.samplekmp.auth.domain

import com.twkim.samplekmp.auth.data.AuthRepository

class SessionManager(
    private val authRepository: AuthRepository
) {
    fun authHeader(): String? {
        val token = authRepository.getAccessToken() ?: return null
        return "Bearer $token"
    }

    fun isLoggedIn(): Boolean = authRepository.isLoggedIn()
}