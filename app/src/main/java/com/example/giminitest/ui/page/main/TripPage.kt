package com.example.giminitest.ui.page.main

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExtendedFloatingActionButton
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
import com.example.giminitest.data.json.LocationInfoBasic
import com.example.giminitest.data.json.done
import com.example.giminitest.data.json.morePlace
import com.example.giminitest.data.json.situation.s1.tmp.S1enItem
import com.example.giminitest.data.json.userInput
import com.example.giminitest.ui.component.Waiting
import com.example.giminitest.ui.component.YoutubeCard
import com.example.giminitest.ui.theme.DefaultBlue
import com.mikepenz.markdown.compose.components.CurrentComponentsBridge.text
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

    val currSelected = remember {
        mutableStateListOf<LocationInfoBasic>().apply { }
    }

    Column(
        modifier.padding(8.dp),
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp),
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
                                var isSelected by remember { mutableStateOf(false) }

                                val borderColor by animateColorAsState(
                                    targetValue =
                                    if (isSelected) DefaultBlue else Color.Transparent,
                                    label = "isSelected"
                                )
                                Box(
                                    Modifier
                                        .size(170.dp)
                                        .clip(RoundedCornerShape(28.dp))
                                        .border(4.dp, borderColor, RoundedCornerShape(28.dp))
                                        .clickable {
                                            if (isSelected) {
                                                isSelected = false
                                                val i =
                                                    currSelected.find { locationInfoBasic -> locationInfoBasic.placeId == it?.placeId }
                                                currSelected.remove(i)
                                            } else {
                                                isSelected = true
                                                val i = LocationInfoBasic(
                                                    it?.placeId ?: return@clickable,
                                                    it.placeName ?: return@clickable
                                                )
                                                currSelected.add(i)
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
                }

                ElevatedCard {
                    it.itinerary?.let {
                        Markdown(it)
                    }
                    it.messages?.let {
                        it.forEach {
                            it?.content?.let { Markdown(it) }
                        }
                    }
                }
            }
        }


        val scope = rememberCoroutineScope()
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ExtendedFloatingActionButton(
                onClick = {
                    scope.launch {
                        isWaiting = true
                        val r = done(tripState.id)
                        list.add(r)
                        isWaiting = false
                    }
                },
                Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Save to Itinerary", fontSize = 16.sp)
                }
            }

            ExtendedFloatingActionButton(
                onClick = {
                    scope.launch {
                        isWaiting = true
                        val r = morePlace(tripState.id, currSelected.toList())
                        Log.d("!!! id", "TripPage: tripState.id = ${tripState.id}")
                        list.add(r)
                        currSelected.clear()
                        isWaiting = false
                    }
                },
                Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Complete Planning", fontSize = 16.sp)
                }
            }
        }


        var text by remember { mutableStateOf("") }
        Card(shape = RoundedCornerShape(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
                TextField(
                    value = text, onValueChange = { text = it }, Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            scope.launch {
                                isWaiting = true
                                val r = userInput(tripState.id, text)
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