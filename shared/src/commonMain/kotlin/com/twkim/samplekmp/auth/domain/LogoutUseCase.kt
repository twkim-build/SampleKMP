package com.twkim.samplekmp.auth.domain

import com.twkim.samplekmp.auth.data.AuthRepository

class LogoutUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke() {
        authRepository.logout()
    }
}