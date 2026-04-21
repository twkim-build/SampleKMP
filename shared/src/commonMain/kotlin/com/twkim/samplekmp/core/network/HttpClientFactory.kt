package com.twkim.samplekmp.core.network

import com.twkim.samplekmp.auth.domain.SessionManager
import com.twkim.samplekmp.core.config.AppConfig
import com.twkim.samplekmp.core.logging.AppLogger
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory(
    private val config: AppConfig,
    private val sessionManager: SessionManager,
    private val logger: AppLogger
) {
    fun create(): HttpClient {
        logger.i("HttpClientFactory", "Creating client for ${config.environment}")

        return platformHttpClient().config {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
            install(DefaultRequest) {
                url(config.baseUrl)
                contentType(ContentType.Application.Json)
                sessionManager.authHeader()?.let { token ->
                    header("Authorization", token)
                }
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15_000
                connectTimeoutMillis = 15_000
                socketTimeoutMillis = 15_000
            }
        }
    }
}