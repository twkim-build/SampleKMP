package com.twkim.samplekmp.auth.data

actual class PlatformTokenStorage: TokenStorage {
    private var accessToken: String? = null
    private var refreshToken: String? = null

    override fun getAccessToken(): String? = accessToken
    override fun getRefreshToken(): String? = refreshToken

    override fun saveTokens(accessToken: String, refreshToken: String?) {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
    }

    override fun clear() {
        accessToken = null
        refreshToken = null
    }
}