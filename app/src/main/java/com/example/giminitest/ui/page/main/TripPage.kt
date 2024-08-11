package com.example.giminitest.ui.page.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.giminitest.Route
import com.example.giminitest.data.json.chatContinue
import com.example.giminitest.data.json.situation.s1.tmp.S1enItem
import com.example.giminitest.ui.component.Waiting
import com.example.giminitest.ui.component.YoutubeCard
import com.example.giminitest.ui.theme.DefaultBlue
import com.mikepenz.markdown.m3.Markdown
import kotlinx.coroutines.launch

//@Preview(
//    widthDp = 730,
//    heightDp = 1112,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true
//)
//@Preview(
//    widthDp = 730,
//    heightDp = 1112,
//    uiMode = Configuration.UI_MODE_NIGHT_NO,
//    showBackground = true
//)
@Composable
fun TripPage(
//    threadId: String,
    tripState: Route.Trip,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isWaiting by remember { mutableStateOf(false) }

    val list = remember {
        mutableStateListOf<S1enItem>().apply { addAll(tripState.s1) }
    }

    Column(
        modifier.padding(8.dp),
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(list) {
                it.userInput?.let {
                    ElevatedCard(
                        colors = CardDefaults.elevatedCardColors()
                            .copy(containerColor = Color(0xFF010c1a))
                    ) {
                        Text(it.joinToString { it ?: "" }, Modifier.padding(8.dp))
                    }
                }

                it.planOptions?.let {
                    ElevatedCard {
                        Column(Modifier.padding(8.dp)) {
                            Text("planOptions", fontSize = 36.sp)
                            Markdown(it)
                        }
                    }
                }

                it.userMessage?.let {
                    ElevatedCard(
                        colors = CardDefaults.elevatedCardColors()
                            .copy(containerColor = Color(0xFF010c1a))
                    ) {
                        Text(it, Modifier.padding(8.dp))
                    }
                }


                it.videoInfo?.let {
                    Column {
                        Text(text = " Recommended Videos", fontSize = 24.sp)
                        Spacer(Modifier.size(8.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            items(it) {
                                YoutubeCard(
                                    it?.videoId ?: return@items,
                                    it.videoTitle ?: return@items,
                                    modifier = Modifier.clickable {
                                        val uri = Uri.parse("vnd.youtube://${it.videoId}")
                                        val youtubeIntent = Intent(Intent.ACTION_VIEW, uri)
                                        youtubeIntent.setPackage("com.google.android.youtube")

                                        if (youtubeIntent.resolveActivity(context.packageManager) != null) {
                                            context.startActivity(youtubeIntent)
                                        } else {
                                            // 處理 YouTube 應用未安裝的情況
                                            // 你可以顯示一個提示訊息，或在瀏覽器中打開視頻的 URL
                                            val webUri =
                                                Uri.parse("https://www.youtube.com/watch?v=${it.videoId}")
                                            val webIntent = Intent(Intent.ACTION_VIEW, webUri)
                                            context.startActivity(webIntent)
                                        }
                                    }
                                )
                            }
                        }
                        Spacer(Modifier.size(8.dp))
                    }
                }


                it.locationInfo?.let {
                    Column {
                        Text(text = "Recommended Places", fontSize = 24.sp)
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            items(it) {
                                Box(
                                    Modifier
                                        .size(170.dp)
                                        .clip(RoundedCornerShape(28.dp))
                                        .clickable {
//                                        val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=${it?.placeName}&query_place_id=${it?.placeId}\n")
                                            val uri =
                                                Uri.parse("https://www.google.com/maps/search/?api=1&query=${it?.placeCoordinates?.latitude},${it?.placeCoordinates?.longitude}")
//                                        val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=${it?.placeCoordinates?.latitude},${it?.placeCoordinates?.longitude},&query_place_id=${it?.placeId}\n")
//                                        val uri = Uri.parse("https://www.google.com/maps/place/?q=place_id:${it?.placeId ?: return@clickable}")
                                            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
                                            mapIntent.setPackage("com.google.android.apps.maps")
                                            if (mapIntent.resolveActivity(context.packageManager) != null) {
                                                context.startActivity(mapIntent)
                                            } else {
                                                // Handle the case where Google Maps app is not installed
                                                // You can show a message to the user or open the URL in a web browser
                                                val webIntent = Intent(Intent.ACTION_VIEW, uri)
                                                context.startActivity(webIntent)
                                            }
                                        }
                                ) {
                                    AsyncImage(
                                        model = it?.photoUrl ?: return@items,
                                        contentDescription = it.placeName,
                                        contentScale = ContentScale.Crop,
                                    )
                                    Text(
                                        it.placeName ?: return@items,
                                        Modifier
                                            .align(Alignment.BottomCenter)
                                            .padding(12.dp)
                                            .clip(RoundedCornerShape(16.dp))
                                            .background(Color.Black.copy(0.7f))
                                            .padding(8.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.size(8.dp))
                    ElevatedCard(
                        colors = CardDefaults.elevatedCardColors()
                            .copy(containerColor = DefaultBlue)
                    ) {
                        Text("Complete Planning", Modifier.padding(12.dp), fontSize = 28.sp)
                    }
                }

                ElevatedCard {
                    it.itinerary?.let {
//                    Text("itinerary", fontSize = 36.sp)
                        Markdown(it)
                    }
//                it.lnode?.let {
//                    Text("lnode", fontSize = 36.sp)
//                    Markdown(it)
//                }
                    it.messages?.let {
//                    Text("messages", fontSize = 36.sp)
                        it.forEach {
                            it?.content?.let { Markdown(it) }
                        }
                    }
                }


                //not sure
//                it.placeName?.let { Text(it) }
//                it.userMessage?.let { Text(it) }
//
//                it.placeId?.let { Text(it) }
            }
        }


        Card(shape = RoundedCornerShape(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
                var text by remember { mutableStateOf("") }
                val scope = rememberCoroutineScope()
                TextField(
                    value = text, onValueChange = { text = it }, Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            tripState.id
                            scope.launch {
                                isWaiting = true
                                val r = chatContinue(tripState.id, text)
                                list.add(r)
                                isWaiting = false
                            }
                        }
                    ),
                )
            }
        }
    }

    if (isWaiting) {
        Waiting()
    }
}