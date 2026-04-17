package com.twkim.samplekmp

import com.twkim.samplekmp.network.UserApi
import com.twkim.samplekmp.presentation.UserStore
import com.twkim.samplekmp.repository.UserRepository
import com.twkim.samplekmp.repository.UserRepositoryImpl
import com.twkim.samplekmp.usecase.GetUserUseCase

class AppContainer {
    fun createUserStore(): UserStore {
        val api = UserApi()
        val repository: UserRepository = UserRepositoryImpl(api)
        val useCase = GetUserUseCase(repository)
        return UserStore(useCase)
    }
}