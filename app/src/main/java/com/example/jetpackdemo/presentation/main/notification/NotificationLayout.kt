package com.example.jetpackdemo.presentation.main.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NotificationLayout() {
    Box (contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Text(text = "Notifications")
    }
}
@Composable
fun BrowseLayout() {
    Box (contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Text(text = "Browse")
    }
}
@Composable
fun MoreLayout() {
    Box (contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Text(text = "More")
    }
}