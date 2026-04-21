package com.twkim.samplekmp.app

import com.twkim.samplekmp.auth.domain.SessionManager
import com.twkim.samplekmp.core.config.AppConfig
import com.twkim.samplekmp.core.logging.AppLogger
import com.twkim.samplekmp.core.network.HttpClientFactory
import io.ktor.client.HttpClient

class CoreModule(
    val config: AppConfig,
    val logger: AppLogger,
    val sessionManager: SessionManager
) {
    private val httpClientFactory by lazy {
        HttpClientFactory(
            config = config,
            sessionManager = sessionManager,
            logger = logger
        )
    }

    val httpClient: HttpClient by lazy {
        httpClientFactory.create()
    }
}