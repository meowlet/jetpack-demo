package com.example.jetpackdemo.presentation.main.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.jetpackdemo.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavHostController, currentDestination: NavDestination?) {
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    NavigationBar {
        items.forEachIndexed { index, item ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            NavigationBarItem(
                selected = isSelected,
                label = { Text(text = item.title, style = MaterialTheme.typography.labelMedium)},
                onClick = { navigateToDestination(navController, index, item.route) },
                icon = { NavigationIcon(item, index, selectedIndex) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationIcon(item: NavigationItem, index: Int, selectedIndex: Int) {
    BadgedBox(
        badge = { BadgeForItem(item) }
    ) {
        Icon(
            imageVector = if (index == selectedIndex) item.selectedIcon else item.unselectedIcon,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeForItem(item: NavigationItem) {
    when {
        item.badgeCount != null -> Badge { Text(text = item.badgeCount.toString()) }
        item.hasNews -> Badge()
    }
}

fun navigateToDestination(navController: NavHostController, index: Int, route: String) {
    navController.navigate(route) {
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
    }
}

val items = listOf(
    NavigationItem.Home,
    NavigationItem.Browse,
    NavigationItem.Notification,
    NavigationItem.More,
)


sealed class NavigationItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
) {
    object Home : NavigationItem(
        route = "home",
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false
    )

    object Browse : NavigationItem(
        route = "browse",
        title = "Browse",
        selectedIcon = Icons.Filled.List,
        unselectedIcon = Icons.Outlined.List,
        hasNews = true
    )

    object Notification : NavigationItem(
        route = "notification",
        title = "Notices",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        hasNews = false,
        badgeCount = 6
    )

    object More : NavigationItem(
        route = "more",
        title = "More",
        selectedIcon = Icons.Filled.MoreVert,
        unselectedIcon = Icons.Outlined.MoreVert,
        hasNews = true
    )
}


@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    AppTheme {
//        BottomBar()
    }
}
