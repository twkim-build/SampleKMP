package com.twkim.samplekmp.presentation

import com.twkim.samplekmp.model.User
import com.twkim.samplekmp.usecase.GetUserUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class UserPresenter(
    private val useCase: GetUserUseCase
) {
    private val scope = MainScope()

    fun loadUser(
        onSuccess: (User) -> Unit,
        onError: (String) -> Unit
    ) {
        scope.launch {
            try {
                val user = useCase()
                onSuccess(user)
            } catch (e: Exception) {
                onError("Error")
            }
        }
    }
}