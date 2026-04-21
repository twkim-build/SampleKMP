package com.twkim.samplekmp.app

import com.twkim.samplekmp.Platform
import com.twkim.samplekmp.auth.data.AuthRepository
import com.twkim.samplekmp.auth.data.PlatformTokenStorage
import com.twkim.samplekmp.auth.data.TokenStorage
import com.twkim.samplekmp.auth.domain.SessionManager
import com.twkim.samplekmp.core.config.AppConfigFactory
import com.twkim.samplekmp.core.config.AppEnvironment
import com.twkim.samplekmp.core.logging.DefaultAppLogger
import com.twkim.samplekmp.user.api.UserApi
import com.twkim.samplekmp.user.presentation.UserStore
import com.twkim.samplekmp.user.data.UserRepository
import com.twkim.samplekmp.user.data.UserRepositoryImpl
import com.twkim.samplekmp.user.domain.GetUserUseCase

class AppContainer(
    environment: AppEnvironment,
    tokenStorage: TokenStorage = PlatformTokenStorage()
) {
    private val config = AppConfigFactory.create(environment)

    private val logger by lazy {
        DefaultAppLogger(enabled = config.enableDebugLogs)
    }

    private val authRepository by lazy {
        AuthRepository(tokenStorage)
    }

    private val sessionManager by lazy {
        SessionManager(authRepository)
    }

    private val coreModule by lazy {
        CoreModule(
            config = config,
            logger = logger,
            sessionManager = sessionManager
        )
    }

    private val authModule by lazy {
        AuthModule(
            coreModule = coreModule,
            authRepository = authRepository,
            sessionManager = sessionManager
        )
    }

    private val userModule by lazy {
        UserModule(coreModule = coreModule)
    }

    fun createAuthStore() = authModule.createAuthStore()

    fun createUserStore() = userModule.createUserStore()
}