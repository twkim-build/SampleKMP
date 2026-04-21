package com.twkim.samplekmp.app

import com.twkim.samplekmp.user.api.UserApi
import com.twkim.samplekmp.user.data.UserRepository
import com.twkim.samplekmp.user.data.UserRepositoryImpl
import com.twkim.samplekmp.user.domain.GetUserUseCase
import com.twkim.samplekmp.user.presentation.UserStore
import kotlin.getValue

class UserModule(
    private val coreModule: CoreModule
) {
    private val userApi by lazy  { UserApi(coreModule.httpClient) }

    private val userRepository: UserRepository by lazy {
        UserRepositoryImpl(userApi)
    }

    private val getUserUseCase by lazy {
        GetUserUseCase(userRepository)
    }

    fun createUserStore(): UserStore {
        return UserStore(getUserUseCase)
    }
}