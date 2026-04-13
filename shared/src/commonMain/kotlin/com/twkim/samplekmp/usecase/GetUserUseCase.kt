package com.twkim.samplekmp.usecase

import com.twkim.samplekmp.model.User
import com.twkim.samplekmp.repository.UserRepositoryImpl

class GetUserUseCase(
    private val repository: UserRepositoryImpl
) {
    suspend operator fun invoke(): User {
        return repository.getUser()
    }
}