package com.twkim.samplekmp.user.presentation

import com.twkim.samplekmp.user.domain.GetUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserStore (
    private val getUserUseCase: GetUserUseCase
) {
    private val scope: CoroutineScope = MainScope()

    private val _state = MutableStateFlow(UserUiState())
    val state: StateFlow<UserUiState> = _state.asStateFlow()

    fun loadUser(userId: String) {
        scope.launch {
            _state.value = _state.value.copy(
                isLoading = true,
                errorMessage = null
            )

            try {
                val user = getUserUseCase(userId)
                _state.value = UserUiState(
                    isLoading = false,
                    name = user.name,
                    email = user.email,
                    errorMessage = null
                )
            } catch (t: Throwable) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = t.message ?: "Unknown error"
                )
            }
        }
    }

    fun currentState(): UserUiState = state.value

    fun watchState(onEach: (UserUiState) -> Unit) {
        scope.launch {
            state.collectLatest { value ->
                onEach(value)
            }
        }
    }

    fun clear() {
        scope.cancel()
    }
}
