package com.example.jetpackdemo.presentation.main.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.jetpackdemo.core.RootGraph
import com.example.jetpackdemo.ui.theme.TestTheme

class Home : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            TestTheme {
                RootGraph(navController = navController)
            }
        }
    }
}






