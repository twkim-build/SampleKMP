package com.twkim.samplekmp.app

import com.twkim.samplekmp.auth.api.AuthApi
import com.twkim.samplekmp.auth.data.AuthRepository
import com.twkim.samplekmp.auth.domain.LoginUseCase
import com.twkim.samplekmp.auth.domain.LogoutUseCase
import com.twkim.samplekmp.auth.domain.SessionManager
import com.twkim.samplekmp.auth.presentation.AuthStore

class AuthModule(
    private val coreModule: CoreModule,
    private val authRepository: AuthRepository,
    private val sessionManager: SessionManager
) {
    private val authApi by lazy { AuthApi(coreModule.httpClient) }

    private val loginUseCase by lazy {
        LoginUseCase(authApi, authRepository)
    }

    private val logoutUseCase by lazy {
        LogoutUseCase(authRepository)
    }

    fun createAuthStore(): AuthStore {
        return AuthStore(
            loginUseCase = loginUseCase,
            logoutUseCase = logoutUseCase,
            sessionManager = sessionManager
        )
    }
}