package com.twkim.samplekmp.network

import com.twkim.samplekmp.model.User
import kotlinx.coroutines.delay

class UserApi {
    suspend fun getUser(userId: String): User {
        delay(1000)

        return User(
            id = userId,
            name = "John Doe",
            email = "john@example.com"
        )
    }
}