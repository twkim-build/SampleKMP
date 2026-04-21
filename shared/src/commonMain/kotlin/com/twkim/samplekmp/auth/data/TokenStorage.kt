package com.twkim.samplekmp.auth.data

interface TokenStorage {
    fun getAccessToken(): String?
    fun getRefreshToken(): String?
    fun saveTokens(accessToken: String, refreshToken: String?)
    fun clear()
}