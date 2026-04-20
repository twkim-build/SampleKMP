package com.twkim.samplekmp.app

import com.twkim.samplekmp.user.api.UserApi
import com.twkim.samplekmp.user.presentation.UserStore
import com.twkim.samplekmp.user.data.UserRepository
import com.twkim.samplekmp.user.data.UserRepositoryImpl
import com.twkim.samplekmp.user.domain.GetUserUseCase

class AppContainer {
    fun createUserStore(): UserStore {
        val api = UserApi()
        val repository: UserRepository = UserRepositoryImpl(api)
        val useCase = GetUserUseCase(repository)
        return UserStore(useCase)
    }
}