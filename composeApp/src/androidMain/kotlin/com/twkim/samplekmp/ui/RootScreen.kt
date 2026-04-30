package com.twkim.samplekmp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.twkim.samplekmp.auth.presentation.AuthStore
import com.twkim.samplekmp.user.presentation.UserStore

@Composable
fun RootScreen(
    authStore: AuthStore,
    userStore: UserStore
) {
    val authState = authStore.state.collectAsStateWithLifecycle()

    if (authState.value.isLoggedIn) {
        ProfileScreen(
            userStore = userStore,
            onLogout = { authStore.logout() }
        )
    } else {
        LoginScreen(authStore = authStore)
    }
}