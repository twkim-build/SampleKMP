package com.twkim.samplekmp.repository

import com.twkim.samplekmp.model.User
import com.twkim.samplekmp.network.UserApi

class UserRepositoryImpl(
    private val api: UserApi
) {
    suspend fun getUser(): User {
        return api.getUser()
    }
}