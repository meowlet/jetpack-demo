package com.example.jetpackdemo.presentation.main.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackdemo.core.HomeGraph
import com.example.jetpackdemo.presentation.main.home.components.BottomBar
import com.example.jetpackdemo.presentation.main.home.components.DetailPageTopBar
//import com.example.jetpackdemo.core.HomeNav
import com.example.jetpackdemo.presentation.main.home.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeLayout() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val isDetailPage = remember { mutableStateOf(false) }

    LaunchedEffect(currentDestination) {
        isDetailPage.value =
            currentDestination?.route == "fictionDetail/{id}/{name}/{description}/{status}"
    }


    val homeScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val detailScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .then(
                if (isDetailPage.value) Modifier.nestedScroll(detailScrollBehavior.nestedScrollConnection) else Modifier.nestedScroll(
                    homeScrollBehavior.nestedScrollConnection
                )
            ), // Use topBarScrollBehavior here
        topBar = {
            // The main logic
            if (isDetailPage.value) DetailPageTopBar(navController, detailScrollBehavior) // Use detailPageTopBarScrollBehavior here
            else TopBar(homeScrollBehavior) // Use topBarScrollBehavior here
        },
        bottomBar = { BottomBar(navController, currentDestination) },
    ) { innerPadding ->
        Surface(
            modifier = Modifier.then(
                if (isDetailPage.value) Modifier.padding(bottom = innerPadding.calculateBottomPadding()) else Modifier.padding(
                    innerPadding
                )
            )
        ) {
            HomeGraph(navController = navController)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeLayout(navController: NavHostController, currentDestination:NavDestination?) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//
//    Scaffold(
//        modifier = Modifier,
//        topBar = { TopBar(scrollBehavior) },
//        bottomBar = { BottomBar(navController, currentDestination) },
//    ) { innerPadding ->
//        Surface(
//            modifier = Modifier.padding(innerPadding)
//            )
//         {
//            HomeNav()
//        }
//    }
//}


















// Just data things for testing
data class Fiction(
    val id: Int,
    val title: String,
    val description: String,
    val status: String,
    val uploaded_at: String,
    val uploader_id: Int,
    val is_manga: Boolean
)

val fictions = listOf(
    Fiction(
        id = 1,
        title = "Attack on Titan",
        description = "In a world where humanity resides within enormous walled cities to protect themselves from Titans...",
        status = "Ongoing",
        uploaded_at = "2024-01-17T12:00:00Z",
        uploader_id = 1,
        is_manga = true
    ),
    Fiction(
        id = 2,
        title = "My Hero Academia",
        description = "In a world where people with superpowers (known as quirks) are the norm...",
        status = "Completed",
        uploaded_at = "2024-01-16T15:30:00Z",
        uploader_id = 2,
        is_manga = true
    ),
    Fiction(
        id = 3,
        title = "Demon Slayer",
        description = "Tanjiro Kamado, a young boy turned demon slayer, seeks revenge on demons who slaughtered his family and turned his sister into a demon.",
        status = "Ongoing",
        uploaded_at = "2024-01-15T14:20:00Z",
        uploader_id = 3,
        is_manga = true
    ),
    Fiction(
        id = 4,
        title = "Jujutsu Kaisen",
        description = "Yuji Itadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friendadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friends.",
        status = "Ongoing",
        uploaded_at = "2024-01-14T09:10:00Z",
        uploader_id = 4,
        is_manga = true
    ),
    Fiction(
        id = 5,
        title = "One Piece",
        description = "Monkey D. Luffy and his crew embark on a journey to find the legendary One Piece, the greatest treasure in the world, and become the Pirate King.",
        status = "Ongoing",
        uploaded_at = "2024-01-13T18:45:00Z",
        uploader_id = 5,
        is_manga = true
    ),
    Fiction(
        id = 6,
        title = "Naruto",
        description = "Naruto Uzumaki, a young ninja with dreams of becoming the strongest ninja and leader of his village, faces various challenges and enemies.",
        status = "Completed",
        uploaded_at = "2024-01-12T11:30:00Z",
        uploader_id = 6,
        is_manga = true
    ),
    Fiction(
        id = 7,
        title = "Death Note",
        description = "Light Yagami discovers a mysterious notebook that allows him to kill anyone whose name he writes in it, leading to a high-stakes game of cat and mouse with a brilliant detective.",
        status = "Completed",
        uploaded_at = "2024-01-11T20:15:00Z",
        uploader_id = 7,
        is_manga = true
    ),
    Fiction(
        id = 8,
        title = "Tokyo Revengers",
        description = "Takemichi Hanagaki discovers he can time travel and attempts to prevent the tragic future of his friends and loved ones by changing the past.",
        status = "Ongoing",
        uploaded_at = "2024-01-10T14:50:00Z",
        uploader_id = 8,
        is_manga = true
    ),
    Fiction(
        id = 9,
        title = "Black Clover",
        description = "Asta, a boy born without magic in a world where magic is everything, aims to become the Wizard King and prove that he can overcome his lack of magical abilities.",
        status = "Ongoing",
        uploaded_at = "2024-01-09T09:25:00Z",
        uploader_id = 9,
        is_manga = true
    ),
    Fiction(
        id = 10,
        title = "Hunter x Hunter",
        description = "Gon Freecss, a young boy, aspires to become a Hunter and find his missing father, Ging Freecss, a legendary Hunter.",
        status = "Ongoing",
        uploaded_at = "2024-01-08T16:40:00Z",
        uploader_id = 10,
        is_manga = true
    ),
    Fiction(
        id = 11,
        title = "Vinland Saga",
        description = "Thorfinn, a young Viking, seeks revenge against the man who killed his father and explores the historical events of the Viking Age.",
        status = "Ongoing",
        uploaded_at = "2024-01-07T12:30:00Z",
        uploader_id = 11,
        is_manga = true
    ),
    Fiction(
        id = 12,
        title = "Fullmetal Alchemist",
        description = "Two brothers, Edward and Alphonse Elric, use alchemy in their quest to search for the Philosopher's Stone to restore their bodies after a failed alchemical experiment.",
        status = "Completed",
        uploaded_at = "2024-01-06T18:20:00Z",
        uploader_id = 12,
        is_manga = true
    ),
    Fiction(
        id = 13,
        title = "Demon Slayer: Kimetsu no Yaiba",
        description = "Tanjiro Kamado, a young boy turned demon slayer, seeks revenge on demons who slaughtered his family and turned his sister into a demon.",
        status = "Completed",
        uploaded_at = "2024-01-05T09:15:00Z",
        uploader_id = 13,
        is_manga = true
    ),
    Fiction(
        id = 14,
        title = "The Promised Neverland",
        description = "A group of orphans discovers the dark truth about their existence and attempts to escape from a sinister orphanage.",
        status = "Completed",
        uploaded_at = "2024-01-04T15:55:00Z",
        uploader_id = 14,
        is_manga = true
    ),
    Fiction(
        id = 15,
        title = "Dragon Ball",
        description = "Goku, a Saiyan warrior, embarks on a journey to become the strongest fighter and protect the Earth from powerful foes.",
        status = "Completed",
        uploaded_at = "2024-01-03T11:40:00Z",
        uploader_id = 15,
        is_manga = true
    ),
    Fiction(
        id = 16,
        title = "Bleach",
        description = "Ichigo Kurosaki gains the powers of a Soul Reaper and must protect the living world from evil spirits and guide departed souls to the afterlife.",
        status = "Completed",
        uploaded_at = "2024-01-02T17:30:00Z",
        uploader_id = 16,
        is_manga = true
    ),
    Fiction(
        id = 17,
        title = "Sword Art Online",
        description = "Players get trapped in a virtual reality MMORPG, and the protagonist must navigate through the game's challenges to escape and save other players.",
        status = "Ongoing",
        uploaded_at = "2024-01-01T13:20:00Z",
        uploader_id = 17,
        is_manga = true
    ),
    Fiction(
        id = 18,
        title = "One Punch Man",
        description = "Saitama, a hero who can defeat any opponent with a single punch, seeks meaning and excitement in his hero activities.",
        status = "Ongoing",
        uploaded_at = "2023-12-31T19:10:00Z",
        uploader_id = 18,
        is_manga = true
    ),
    Fiction(
        id = 19,
        title = "Black Butler",
        description = "Ciel Phantomhive, a young earl, forms a contract with a demon butler to seek revenge on those who murdered his parents.",
        status = "Ongoing",
        uploaded_at = "2023-12-30T14:50:00Z",
        uploader_id = 19,
        is_manga = true
    ),
    Fiction(
        id = 20,
        title = "Fairy Tail",
        description = "Natsu Dragneel and his friends, wizards of the Fairy Tail guild, embark on adventures and face powerful enemies to protect their world.",
        status = "Completed",
        uploaded_at = "2023-12-29T09:45:00Z",
        uploader_id = 20,
        is_manga = true
    )
)

val fictionss = listOf(
    Fiction(
        id = 1,
        title = "Attack on Titsssssan",
        description = "In a world where humanity resides within enormous walled cities to protect themselves from Titans...",
        status = "Ongoing",
        uploaded_at = "2024-01-17T12:00:00Z",
        uploader_id = 1,
        is_manga = true
    ),
    Fiction(
        id = 2,
        title = "My Hero Academia",
        description = "In a world where people with superpowers (known as quirks) are the norm...",
        status = "Completed",
        uploaded_at = "2024-01-16T15:30:00Z",
        uploader_id = 2,
        is_manga = true
    ),
    Fiction(
        id = 3,
        title = "Demon Slayer",
        description = "Tanjiro Kamado, a young boy turned demon slayer, seeks revenge on demons who slaughtered his family and turned his sister into a demon.",
        status = "Ongoing",
        uploaded_at = "2024-01-15T14:20:00Z",
        uploader_id = 3,
        is_manga = true
    ),
    Fiction(
        id = 4,
        title = "Jujutsu Kaisen",
        description = "Yuji Itadori joins a secret organization to battle curses after consuming a powerful, cursed object to save his friends.",
        status = "Ongoing",
        uploaded_at = "2024-01-14T09:10:00Z",
        uploader_id = 4,
        is_manga = true
    ),
    Fiction(
        id = 5,
        title = "One Piece",
        description = "Monkey D. Luffy and his crew embark on a journey to find the legendary One Piece, the greatest treasure in the world, and become the Pirate King.",
        status = "Ongoing",
        uploaded_at = "2024-01-13T18:45:00Z",
        uploader_id = 5,
        is_manga = true
    ),
    Fiction(
        id = 6,
        title = "Naruto",
        description = "Naruto Uzumaki, a young ninja with dreams of becoming the strongest ninja and leader of his village, faces various challenges and enemies.",
        status = "Completed",
        uploaded_at = "2024-01-12T11:30:00Z",
        uploader_id = 6,
        is_manga = true
    ),
    Fiction(
        id = 7,
        title = "Death Note",
        description = "Light Yagami discovers a mysterious notebook that allows him to kill anyone whose name he writes in it, leading to a high-stakes game of cat and mouse with a brilliant detective.",
        status = "Completed",
        uploaded_at = "2024-01-11T20:15:00Z",
        uploader_id = 7,
        is_manga = true
    ),
    Fiction(
        id = 8,
        title = "Tokyo Revengers",
        description = "Takemichi Hanagaki discovers he can time travel and attempts to prevent the tragic future of his friends and loved ones by changing the past.",
        status = "Ongoing",
        uploaded_at = "2024-01-10T14:50:00Z",
        uploader_id = 8,
        is_manga = true
    ),
    Fiction(
        id = 9,
        title = "Black Clover",
        description = "Asta, a boy born without magic in a world where magic is everything, aims to become the Wizard King and prove that he can overcome his lack of magical abilities.",
        status = "Ongoing",
        uploaded_at = "2024-01-09T09:25:00Z",
        uploader_id = 9,
        is_manga = true
    ),
    Fiction(
        id = 10,
        title = "Hunter x Hunter",
        description = "Gon Freecss, a young boy, aspires to become a Hunter and find his missing father, Ging Freecss, a legendary Hunter.",
        status = "Ongoing",
        uploaded_at = "2024-01-08T16:40:00Z",
        uploader_id = 10,
        is_manga = true
    ),
    Fiction(
        id = 11,
        title = "Vinland Saga",
        description = "Thorfinn, a young Viking, seeks revenge against the man who killed his father and explores the historical events of the Viking Age.",
        status = "Ongoing",
        uploaded_at = "2024-01-07T12:30:00Z",
        uploader_id = 11,
        is_manga = true
    ),
    Fiction(
        id = 12,
        title = "Fullmetal Alchemist",
        description = "Two brothers, Edward and Alphonse Elric, use alchemy in their quest to search for the Philosopher's Stone to restore their bodies after a failed alchemical experiment.",
        status = "Completed",
        uploaded_at = "2024-01-06T18:20:00Z",
        uploader_id = 12,
        is_manga = true
    ),
    Fiction(
        id = 13,
        title = "Demon Slayer: Kimetsu no Yaiba",
        description = "Tanjiro Kamado, a young boy turned demon slayer, seeks revenge on demons who slaughtered his family and turned his sister into a demon.",
        status = "Completed",
        uploaded_at = "2024-01-05T09:15:00Z",
        uploader_id = 13,
        is_manga = true
    ),
    Fiction(
        id = 14,
        title = "The Promised Neverland",
        description = "A group of orphans discovers the dark truth about their existence and attempts to escape from a sinister orphanage.",
        status = "Completed",
        uploaded_at = "2024-01-04T15:55:00Z",
        uploader_id = 14,
        is_manga = true
    ),
    Fiction(
        id = 15,
        title = "Dragon Ball",
        description = "Goku, a Saiyan warrior, embarks on a journey to become the strongest fighter and protect the Earth from powerful foes.",
        status = "Completed",
        uploaded_at = "2024-01-03T11:40:00Z",
        uploader_id = 15,
        is_manga = true
    ),
    Fiction(
        id = 16,
        title = "Bleach",
        description = "Ichigo Kurosaki gains the powers of a Soul Reaper and must protect the living world from evil spirits and guide departed souls to the afterlife.",
        status = "Completed",
        uploaded_at = "2024-01-02T17:30:00Z",
        uploader_id = 16,
        is_manga = true
    ),
    Fiction(
        id = 17,
        title = "Sword Art Online",
        description = "Players get trapped in a virtual reality MMORPG, and the protagonist must navigate through the game's challenges to escape and save other players.",
        status = "Ongoing",
        uploaded_at = "2024-01-01T13:20:00Z",
        uploader_id = 17,
        is_manga = true
    ),
    Fiction(
        id = 18,
        title = "One Punch Man",
        description = "Saitama, a hero who can defeat any opponent with a single punch, seeks meaning and excitement in his hero activities.",
        status = "Ongoing",
        uploaded_at = "2023-12-31T19:10:00Z",
        uploader_id = 18,
        is_manga = true
    ),
    Fiction(
        id = 19,
        title = "Black Butler",
        description = "Ciel Phantomhive, a young earl, forms a contract with a demon butler to seek revenge on those who murdered his parents.",
        status = "Ongoing",
        uploaded_at = "2023-12-30T14:50:00Z",
        uploader_id = 19,
        is_manga = true
    ),
    Fiction(
        id = 20,
        title = "Fairy Tail",
        description = "Natsu Dragneel and his friends, wizards of the Fairy Tail guild, embark on adventures and face powerful enemies to protect their world.",
        status = "Completed",
        uploaded_at = "2023-12-29T09:45:00Z",
        uploader_id = 20,
        is_manga = true
    )
)