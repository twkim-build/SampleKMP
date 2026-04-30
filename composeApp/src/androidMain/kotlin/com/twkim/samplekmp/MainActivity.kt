package com.twkim.samplekmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.twkim.samplekmp.ui.RootScreen
import com.twkim.samplekmp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    private val container = AndroidContainer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                RootScreen(
                    authStore = container.authStore,
                    userStore = container.userStore
                )
            }
        }

//        enableEdgeToEdge()
//        super.onCreate(savedInstanceState)
//
//        setContent {
//            _root_ide_package_.com.twkim.samplekmp.App()
//        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    _root_ide_package_.com.twkim.samplekmp.App()
}