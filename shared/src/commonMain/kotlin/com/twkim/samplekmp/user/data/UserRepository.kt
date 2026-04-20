package com.twkim.samplekmp.user.data

import com.twkim.samplekmp.model.User

interface UserRepository {
    suspend fun getUser(userId: String): User
}