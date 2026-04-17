package com.twkim.samplekmp.repository

import com.twkim.samplekmp.model.User
import com.twkim.samplekmp.network.UserApi

class UserRepositoryImpl(
    private val api: UserApi
) : UserRepository {
    override suspend fun getUser(userId: String): User {
        return api.getUser(userId)
    }
}