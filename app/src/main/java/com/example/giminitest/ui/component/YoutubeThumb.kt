package com.example.giminitest.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun YoutubeThumb(videoId: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = "https://img.youtube.com/vi/${videoId}/maxresdefault.jpg",
        contentDescription = null,
        modifier,
        contentScale = ContentScale.Crop
    )
}