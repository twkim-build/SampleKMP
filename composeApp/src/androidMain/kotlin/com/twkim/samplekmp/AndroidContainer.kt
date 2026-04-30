package com.twkim.samplekmp

import com.twkim.samplekmp.app.AppContainer
import com.twkim.samplekmp.core.config.AppEnvironment

class AndroidContainer {
    private val appContainer = AppContainer(
        environment = AppEnvironment.DEV
    )

    val authStore = appContainer.createAuthStore()
    val userStore = appContainer.createUserStore()
}