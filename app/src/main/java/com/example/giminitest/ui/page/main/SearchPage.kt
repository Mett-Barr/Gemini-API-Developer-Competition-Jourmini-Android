package com.example.giminitest.ui.page.main

import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachFile
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.giminitest.Route
import com.example.giminitest.data.json.situation.s0.S0
import com.example.giminitest.data.json.situation.s1.S1Request
import com.example.giminitest.data.json.situation.s1.tmp.S1enItem
import com.example.giminitest.ui.component.Waiting
import com.example.giminitest.ui.theme.DefaultBlue
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlin.random.Random

@Preview(
    widthDp = 730,
    heightDp = 1112,
    showBackground = true,
//    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    SearchPage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPage(
    navigateToTrip: (Route.Trip) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(false) }
    var isWaiting by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val list = remember {
        mutableStateListOf<S0>()
    }

    LaunchedEffect(Unit) {
        list.addAll(S0.getFakeList())
    }

    val selectedList = remember {
        mutableStateListOf<Int>()
    }

    fun searchByText() {
        scope.launch {
            isWaiting = true
            val id = Random.nextInt().toString()
            val r = S1Request(
                thread_id = id,
                user_interaction = text
            )

            Log.d("!!! id", "searchByText: id = $id")

            val client = HttpClient {
                install(ContentNegotiation) {
                    json(Json { ignoreUnknownKeys = true })  // 安裝JSON支持
                }
            }

            // API的URL
            val url = "https://langraphagent-production.up.railway.app/api/v1/llm/chat/init"

            try {
                // 發送POST請求
                val response: HttpResponse = client.post(url) {
                    contentType(ContentType.Application.Json)
                    setBody(r)
                }
                val responseBody: S1enItem = response.body()

                Log.d("!!!", "SearchPage: responseBody\n$responseBody")

                navigateToTrip(Route.Trip(id, listOf(responseBody)))
            } catch (e: Exception) {
                Log.d("!!!", "Error occurred: ${e.message}")
            } finally {
                client.close()  // 關閉HttpClient
                isWaiting = false
            }
        }
    }
    Column(
        modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(
            Modifier
                .weight(1f)
                .width(150.dp)
        )
        val fillMaxWidth = Modifier.fillMaxWidth()
        Text(
            text = "Plane Next Adventure",
            fillMaxWidth,
            style = MaterialTheme.typography.headlineSmall
        )
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
                            searchByText()
                        }
                    ),
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = fillMaxWidth
        ) {
            FilledTonalButton(onClick = ::searchByText) {
                Row {
                    Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
                }
                Text(text = "Search")
            }
            FilledTonalButton(onClick = { showBottomSheet = true }) {
                Row {
                    Icon(imageVector = Icons.Rounded.AttachFile, contentDescription = null)
                }
                Text(text = "Explore")
            }
        }
        Spacer(
            Modifier
                .weight(1f)
                .width(150.dp)
        )
    }


    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,
            modifier = modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                itemsIndexed(list) { index, it ->
                    var isSelected by remember {
                        mutableStateOf(false)
                    }
                    LaunchedEffect(Unit) {
                        if (selectedList.contains(index)) isSelected = true
                    }

                    val borderColor by animateColorAsState(
                        targetValue =
                        if (isSelected) DefaultBlue else Color.Transparent, label = "isSelected"
                    )

                    Column(
                        Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .border(4.dp, borderColor, RoundedCornerShape(8.dp))
                            .clickable {
                                scope.launch {
                                    if (isSelected) {
                                        selectedList.remove(index)
                                        isSelected = false
                                    } else {
                                        selectedList.add(index)
                                        isSelected = true
                                    }
                                }
                            }) {
                        AsyncImage(
                            model = it.photoUrl,
                            contentDescription = it.placeName,
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = it.placeName ?: "",
                            Modifier
                                .padding(8.dp)
                                .height(48.dp)
                        )
                    }
                }
            }

            ExtendedFloatingActionButton(onClick = {
                scope.launch {
                    sheetState.hide()
                    isWaiting = true
                    val id = Random.nextInt().toString()
                    val r = S1Request(
                        locations = selectedList.map { list[it].placeName ?: "" },
                        thread_id = id
                    )
                    Log.d("!!! id", "S1Request = $r")


                    val client = HttpClient {
                        install(ContentNegotiation) {
                            json(Json { ignoreUnknownKeys = true })  // 安裝JSON支持
                        }
                    }

                    // API的URL
                    val url = "https://langraphagent-production.up.railway.app/api/v1/llm/chat/init"


                    try {
                        // 發送POST請求
                        val response: HttpResponse = client.post(url) {
                            contentType(ContentType.Application.Json)
                            setBody(r)
                        }
                        val responseBody: S1enItem = response.body()

                        Log.d("!!!", "SearchPage: responseBody\n$responseBody")

                        navigateToTrip(Route.Trip(id, listOf(responseBody)))
                    } catch (e: Exception) {
                        Log.d("!!!", "Error occurred: ${e.message}")
                    } finally {
                        client.close()  // 關閉HttpClient
                        isWaiting = false
                    }
                }
            },
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Rounded.Map, contentDescription = null, Modifier.size(48.dp))
                    Spacer(modifier = Modifier.size(16.dp))
                    Text("Plan My Trip", fontSize = 24.sp)
                }
            }
        }
    }

    if (isWaiting) {
        Waiting()
    }
}
