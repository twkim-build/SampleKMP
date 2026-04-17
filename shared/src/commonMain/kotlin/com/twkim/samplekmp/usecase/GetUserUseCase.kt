package com.twkim.samplekmp.usecase

import com.twkim.samplekmp.model.User
import com.twkim.samplekmp.repository.UserRepository
import com.twkim.samplekmp.repository.UserRepositoryImpl

class GetUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: String): User {
        return repository.getUser(userId)
    }
}