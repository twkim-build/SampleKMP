package com.twkim.samplekmp.user.api

import com.twkim.samplekmp.model.User
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class UserApi(
    private val client: HttpClient
) {
    suspend fun getUser(userId: String): User {
        delay(1000)

        return User(
            id = userId,
            name = "John Doe",
            email = "john@example.com"
        )
    }
}