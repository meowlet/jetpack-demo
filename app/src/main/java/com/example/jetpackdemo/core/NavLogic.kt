package com.example.jetpackdemo.core

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackdemo.presentation.external.DetailScreen.DetailLayout
import com.example.jetpackdemo.presentation.main.home.HomeLayout
import com.example.jetpackdemo.presentation.main.home.components.FictionGrid
import com.example.jetpackdemo.presentation.main.home.components.NavigationItem
import com.example.jetpackdemo.presentation.main.home.fictions
import com.example.jetpackdemo.presentation.main.notification.BrowseLayout
import com.example.jetpackdemo.presentation.main.notification.MoreLayout
import com.example.jetpackdemo.presentation.main.notification.NotificationLayout

@Composable
fun NavGraph(navController: NavHostController) {
//    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(route = NavigationItem.Home.route) {
            FictionGrid(fictions = fictions, navController = navController)
        }
        composable(route = NavigationItem.Browse.route) { BrowseLayout() }
        composable(route = NavigationItem.Notification.route) { NotificationLayout() }
        composable(route = NavigationItem.More.route) { MoreLayout() }
        composable(route = "fictionDetail/{id}/{name}/{description}/{status}") { backStackEntry ->
            DetailLayout(
                backStackEntry.arguments?.getString("id") ?: "Not Available",
                backStackEntry.arguments?.getString("name") ?: "Not Available",
                backStackEntry.arguments?.getString("description") ?: "Not Available",
                backStackEntry.arguments?.getString("status") ?: "Not Available"
            )
        }

    }
}

//@Composable
//fun RootNav() {
//    val navController = rememberNavController()
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//    NavHost(
//        navController = navController,
//        startDestination = "root"
//    ) {
//        composable(route = "root") {
//            HomeNav(navController = navController)
//        }
//    }
//}
