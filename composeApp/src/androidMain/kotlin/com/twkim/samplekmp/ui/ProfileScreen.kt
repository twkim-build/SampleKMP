package com.twkim.samplekmp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.twkim.samplekmp.user.presentation.UserStore

@Composable
fun ProfileScreen(
    userStore: UserStore,
    onLogout: () -> Unit
) {
    val state = userStore.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        when {
            state.value.isLoading -> {
                CircularProgressIndicator()
            }

            state.value.errorMessage != null -> {
                Text(
                    text = state.value.errorMessage.orEmpty(),
                    color = MaterialTheme.colorScheme.error
                )
            }

            else -> {
                Text("Name: ${state.value.name}")
                Text("Email: ${state.value.email}")
            }
        }

        Button(onClick = { userStore.loadUser("123") }) {
            Text("Load Profile")
        }

        OutlinedButton(onClick = onLogout) {
            Text("Logout")
        }
    }
}