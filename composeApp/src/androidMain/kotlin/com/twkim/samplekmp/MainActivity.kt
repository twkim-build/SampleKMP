package com.twkim.samplekmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            _root_ide_package_.com.twkim.samplekmp.App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    _root_ide_package_.com.twkim.samplekmp.App()
}