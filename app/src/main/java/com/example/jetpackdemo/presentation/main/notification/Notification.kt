package com.example.jetpackdemo.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackdemo.presentation.main.home.HomeLayout
import com.example.jetpackdemo.presentation.main.notification.NotificationLayout
import com.example.jetpackdemo.ui.theme.AppTheme

class Notification : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotificationPreview() {
    AppTheme {
        NotificationLayout()
    }
}
