package com.example.giminitest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.giminitest.ui.theme.DefaultBlue

@Composable
fun YoutubeCard(
    id: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(modifier.clip(RoundedCornerShape(16.dp))) {
        YoutubeThumb(
            videoId = id,
            Modifier
                .width(200.dp)
                .aspectRatio(128f / 72f)
        )
        Text(
            text = title,
            Modifier
                .background(DefaultBlue)
                .width(200.dp)
                .padding(8.dp)
                .height(50.dp),
        )
    }
}