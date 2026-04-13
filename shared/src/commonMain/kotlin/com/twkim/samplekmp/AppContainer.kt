package com.twkim.samplekmp

import com.twkim.samplekmp.network.UserApi
import com.twkim.samplekmp.presentation.UserPresenter
import com.twkim.samplekmp.repository.UserRepositoryImpl
import com.twkim.samplekmp.usecase.GetUserUseCase

class AppContainer {
    fun createPresenter(): UserPresenter {
        val api = UserApi()
        val repo = UserRepositoryImpl(api)
        val useCase = GetUserUseCase(repo)
        return UserPresenter(useCase)
    }
}