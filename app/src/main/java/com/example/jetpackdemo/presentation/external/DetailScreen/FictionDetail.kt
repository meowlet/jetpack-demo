package com.example.jetpackdemo.presentation.external.DetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackdemo.presentation.main.home.components.BottomBar
import com.example.jetpackdemo.presentation.main.home.components.DetailPageTopBar
import com.example.jetpackdemo.ui.theme.AppTheme

@Composable
fun DetailLayout(id: String, name: String, description: String, status: String) {

    val gradient = Brush.verticalGradient(
        0f to MaterialTheme.colorScheme.surface.copy(alpha = 0.8F),
        1F to MaterialTheme.colorScheme.surface.copy(alpha = 1F)
    )


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        {


            Image(
                painter = rememberAsyncImagePainter(
                    "https://picsum.photos/seed/$id/300/200"
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient)
                        }
                    }
            )



            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        "https://picsum.photos/seed/$id/300/200"
                    ),

                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(150.dp)
                        .aspectRatio(9f / 14f)
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .padding(start = 12.dp, bottom = 32.dp)
                        .fillMaxHeight()
                ) {
                    Text(text = "$name", style = MaterialTheme.typography.titleLarge)
                    Text(text = "Uploader: Bắc kỳ chó", style = MaterialTheme.typography.titleMedium)
                    Text(text = "Status: $status", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp), horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Outlined.Favorite, contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "Love", style = MaterialTheme.typography.labelMedium)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "Subscribe", style = MaterialTheme.typography.labelMedium)
            }
        }
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
    }

}


