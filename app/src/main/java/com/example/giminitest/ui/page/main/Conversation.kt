package com.example.giminitest.ui.page.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.giminitest.data.json.ApiJson
import kotlin.random.Random

@Composable
fun ConversationPage(
    navigate: () -> Unit = {},
    apiJson: ApiJson = ApiJson.fakeJsonObject,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(apiJson.items) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                it.comment?.let { MyText(it) }
                it.llmOutput?.let { MyText(it) }
                it.planData?.let {
                    it.finalPlan?.let { MyText(it) }
                    it.transportationInfo?.let { MyText(it) }
                }
                it.systemOutput?.let {
                    it.systemMessage?.let { MyText(it) }
                }
                it.userInput?.let { MyText(it) }
                it.userInteraction?.let { MyText(it) }
                it.userSystemInput?.let {
                    it.interestedLocations?.forEach {
                        it.name?.let { MyText(it) }
                        it.placeId?.let { MyText(it) }
                    }
                }
            }
        }
    }
}

@Composable
fun MyText(text: String, modifier: Modifier = Modifier) {
    val color = Color(Random.nextLong()).copy(1f).lightenColor()
    val textColor = MaterialTheme.colorScheme.contentColorFor(color)
    Text(text, modifier.clip(RoundedCornerShape(12.dp)).background(color).padding(12.dp), color = textColor)
}

fun Color.lightenColor(): Color {
    val safeFactor = Random.nextFloat().coerceIn(0f, 1f)

    // 使用copy函數調整RGB通道
    return copy(
        red = red + (1 - red) * safeFactor,
        green = green + (1 - green) * safeFactor,
        blue = blue + (1 - blue) * safeFactor
    )
}

fun randomLightColor(): Color = Color(Random.nextLong()).copy(1f).lightenColor()