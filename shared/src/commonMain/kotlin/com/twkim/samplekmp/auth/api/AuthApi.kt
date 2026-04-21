package com.twkim.samplekmp.auth.api

import com.twkim.samplekmp.model.LoginResult
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class AuthApi(
    private val client: HttpClient
) {
    suspend fun login(email: String, password: String): LoginResult {
        delay(1000)

        if (email == "demo@example.com" && password == "1234") {
            return LoginResult(
                accessToken = "demo-access-token",
                refreshToken = "demo-refresh-token"
            )
        } else {
            throw IllegalArgumentException("Invalid email or password")
        }
    }
}