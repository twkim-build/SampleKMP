package com.twkim.samplekmp.repository

import com.twkim.samplekmp.model.User

interface UserRepository {
    suspend fun getUser(userId: String): User
}