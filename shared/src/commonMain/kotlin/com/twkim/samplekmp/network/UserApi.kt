package com.twkim.samplekmp.network

import com.twkim.samplekmp.model.User

class UserApi {
    suspend fun getUser(): User {
        Thread.sleep(1000)
        return User(
            name = "John Doe",
            email = "john@example.com"
        )
    }
}