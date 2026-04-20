package com.twkim.samplekmp.user.data

import com.twkim.samplekmp.model.User
import com.twkim.samplekmp.user.api.UserApi

class UserRepositoryImpl(
    private val api: UserApi
) : UserRepository {
    override suspend fun getUser(userId: String): User {
        return api.getUser(userId)
    }
}