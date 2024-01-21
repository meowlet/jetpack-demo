package com.example.jetpackdemo.presentation.external.DetailScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import com.example.jetpackdemo.presentation.main.home.components.DetailPageTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenLayout(id: String, name: String, description: String, status:String) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Surface(
        ) {
            DetailLayout(id = id, name = name, description = description, status = status )
        }
    }
}