package com.twkim.samplekmp.core.config

data class AppConfig (
    val environment: AppEnvironment,
    val baseUrl: String,
    val enableNetworkLogs: Boolean,
    val enableDebugLogs: Boolean
)