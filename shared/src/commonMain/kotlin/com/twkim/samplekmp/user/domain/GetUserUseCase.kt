package com.twkim.samplekmp.user.domain

import com.twkim.samplekmp.model.User
import com.twkim.samplekmp.user.data.UserRepository

class GetUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: String): User {
        return repository.getUser(userId)
    }
}