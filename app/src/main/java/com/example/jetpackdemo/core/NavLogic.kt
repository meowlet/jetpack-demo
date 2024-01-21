package com.example.jetpackdemo.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackdemo.presentation.external.DetailScreen.DetailScreenLayout
import com.example.jetpackdemo.presentation.main.home.HomeLayout
import com.example.jetpackdemo.presentation.main.home.components.FictionGrid
import com.example.jetpackdemo.presentation.main.home.components.NavigationItem
import com.example.jetpackdemo.presentation.main.home.fictions
import com.example.jetpackdemo.presentation.main.notification.ExploreLayout
import com.example.jetpackdemo.presentation.main.notification.MoreLayout
import com.example.jetpackdemo.presentation.main.notification.NotificationLayout




@Composable
fun HomeGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Browse.route
    ) {
        composable(route = NavigationItem.Browse.route) {
            FictionGrid(fictions = fictions, navController = navController)
        }
        composable(route = NavigationItem.Explore.route) { ExploreLayout() }
        composable(route = NavigationItem.Notification.route) { NotificationLayout() }
        composable(route = NavigationItem.More.route) { MoreLayout() }
        composable(route = "fictionDetail/{id}/{name}/{description}/{status}") { backStackEntry ->
            DetailScreenLayout(
                backStackEntry.arguments?.getString("id") ?: "Not Available",
                backStackEntry.arguments?.getString("name") ?: "Not Available",
                backStackEntry.arguments?.getString("description") ?: "Not Available",
                backStackEntry.arguments?.getString("status") ?: "Not Available"
            )
        }

    }
}

@Composable
fun RootGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "root"
    ) {
        composable(route = "root") {
            HomeLayout()
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
