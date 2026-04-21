package com.twkim.samplekmp.user.presentation

data class UserUiState (
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val errorMessage: String? = null
)