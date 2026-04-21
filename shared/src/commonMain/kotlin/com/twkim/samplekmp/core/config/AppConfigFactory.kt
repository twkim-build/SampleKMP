package com.twkim.samplekmp.core.config

object AppConfigFactory {
    fun create(environment: AppEnvironment): AppConfig {
        return when(environment) {
            AppEnvironment.DEV -> AppConfig(
                environment = environment,
                baseUrl = "https://dev-api.example.com",
                enableNetworkLogs = true,
                enableDebugLogs = true
            )
            AppEnvironment.STAGING -> AppConfig (
                environment = environment,
                baseUrl = "https://staging-api.example.com",
                enableNetworkLogs = true,
                enableDebugLogs = true
            )
            AppEnvironment.PROD -> AppConfig (
                environment = environment,
                baseUrl = "https://api.example.com",
                enableNetworkLogs = false,
                enableDebugLogs = false
            )
        }
    }
}