package com.twkim.samplekmp.auth.data

class AuthRepository(
    private val tokenStorage: TokenStorage
) {
    fun isLoggedIn(): Boolean = !tokenStorage.getAccessToken().isNullOrBlank()

    fun getAccessToken(): String? = tokenStorage.getAccessToken()

    fun saveTokens(accessToken: String, refreshToken: String?) {
        tokenStorage.saveTokens(accessToken, refreshToken)
    }

    fun logout() {
        tokenStorage.clear()
    }
}