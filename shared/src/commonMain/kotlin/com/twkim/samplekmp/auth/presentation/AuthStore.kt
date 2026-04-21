package com.twkim.samplekmp.auth.presentation

import com.twkim.samplekmp.auth.domain.LoginUseCase
import com.twkim.samplekmp.auth.domain.LogoutUseCase
import com.twkim.samplekmp.auth.domain.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AuthStore(
    private val loginUseCase: LoginUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val sessionManager: SessionManager
) {
    private val scope: CoroutineScope = MainScope()

    private val _state = MutableStateFlow(
        AuthUiState(isLoggedIn = sessionManager.isLoggedIn())
    )
    val state: StateFlow<AuthUiState> = _state.asStateFlow()

    fun login(email: String, password: String) {
        scope.launch {
            _state.value = _state.value.copy(
                isLoading = true,
                errorMessage = null
            )

            try {
                loginUseCase(email, password)
                _state.value = _state.value.copy(
                    isLoading = false,
                    true,
                    errorMessage = null
                )
            } catch (t: Throwable) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    isLoggedIn = false,
                    errorMessage = t.message ?: "Unknown error"
                )
            }
        }
    }

    fun logout() {
        logoutUseCase()
        _state.value = AuthUiState(
            isLoading = false,
            isLoggedIn = false,
            errorMessage = null
        )
    }

    fun currentState(): AuthUiState = state.value

    fun watchState(onEach: (AuthUiState) -> Unit) {
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