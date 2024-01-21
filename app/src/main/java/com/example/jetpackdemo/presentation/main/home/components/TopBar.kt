package com.example.jetpackdemo.presentation.main.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetpackdemo.presentation.main.notification.NotificationLayout
import com.example.jetpackdemo.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(scrollBehavior: TopAppBarScrollBehavior) {
    var isSearching by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    if (!isSearching) {
        TopAppBar(
            title = { AppBarTitle() },
            actions = { AppBarActions(isSearching) { isSearching = it } },
            scrollBehavior = scrollBehavior
        )
    } else {
        SearchBar(isSearching, focusRequester, scrollBehavior) { isSearching = it }
    }
}

@Composable
fun AppBarTitle() {
    Column {
        Text(
            text = "Meow",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(text = "Welcome, Meow-sama!", style = MaterialTheme.typography.labelSmall)
    }
}

@Composable
fun AppBarActions(isSearching: Boolean, onSearchStateChange: (Boolean) -> Unit) {
    if (!isSearching) {
        IconButton(onClick = { onSearchStateChange(!isSearching) }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
        }
    }
    ActionButton(Icons.Default.List)
    ActionButton(Icons.Default.AccountCircle)
}

@Composable
fun ActionButton(icon: ImageVector) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = icon, contentDescription = "")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchState: Boolean,
    focusRequester: FocusRequester,
    scrollBehavior: TopAppBarScrollBehavior,
    onSearchStateChange: (Boolean) -> Unit
) {
    val searchText = remember { mutableStateOf("") }
    TopAppBar(
        title = { SearchField(searchText, focusRequester) },
        navigationIcon = {
            IconButton(onClick = { onSearchStateChange(!searchState) }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Localized description")
            }
        },
        actions = {
            if (searchText.value.isNotEmpty()) {
                IconButton(onClick = { searchText.value = "" }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "")
                }
            }
            ActionButton(Icons.Default.List)
            ActionButton(Icons.Default.AccountCircle)
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPageTopBar(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    val searchText = remember { mutableStateOf("") }
    TopAppBar(
        title = {  },
        navigationIcon = {
            IconButton(onClick = { navController.navigate("home") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Localized description")
            }
        },
        actions = {
            ActionButton(Icons.Default.Done)
            ActionButton(Icons.Default.List)
            ActionButton(Icons.Default.AccountCircle)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(0F),
            scrolledContainerColor = MaterialTheme.colorScheme.inverseOnSurface
        ),
        scrollBehavior = scrollBehavior
    )
}




@Composable
fun SearchField(searchText: MutableState<String>, focusRequester: FocusRequester) {
    TextField(
        textStyle = MaterialTheme.typography.bodyLarge,
        singleLine = true,
        placeholder = { Text(text = "Type to search...") },
        value = searchText.value,
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),

        onValueChange = { newText -> searchText.value = newText },
        modifier = Modifier
            .padding(bottom = 3.dp)
            .focusRequester(focusRequester)
    )
    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    AppTheme {
        NotificationLayout()
    }
}
