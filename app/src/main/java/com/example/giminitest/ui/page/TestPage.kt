package com.example.giminitest.ui.page

import android.graphics.Bitmap
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.giminitest.BakingViewModel
import com.example.giminitest.BuildConfig
import com.example.giminitest.MainActivity
import com.example.giminitest.Model
import com.example.giminitest.data.TravelPlan
import com.example.giminitest.data.getPlaceDetails
import com.example.giminitest.data.travelPlanString
import com.example.giminitest.uriToBitmap
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.ImagePart
import com.google.ai.client.generativeai.type.TextPart
import com.google.ai.client.generativeai.type.content
import com.google.android.libraries.places.api.Places
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

val emptyString = TextFieldValue()

@Composable
fun GeminiTestPage(modifier: Modifier = Modifier, bakingViewModel: BakingViewModel = viewModel()) {
    val context = LocalContext.current as MainActivity
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    val model = bakingViewModel.generativeModel
    val list = remember { mutableStateListOf<Content>() }
    var curr by remember { mutableStateOf(TextFieldValue()) }
    val images = remember { mutableStateListOf<Bitmap>() }

    var isShowingDialog by remember { mutableStateOf(false) }

    val getImage = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) {
        scope.launch(Dispatchers.Default) {
            val bitmap = uriToBitmap(context, it ?: return@launch) ?: return@launch
            images.add(bitmap)
        }
    }

    val capture = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) {
        images.add(it ?: return@rememberLauncherForActivityResult)
    }

    Column(
        modifier = modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            itemsIndexed(list, key = { index, _ -> index }) { _, content ->
                Column(Modifier.fillMaxWidth()) {
                    val isUser = content.role == "user"
                    Card(
                        Modifier
                            .align(if (isUser) Alignment.End else Alignment.Start)
                            .wrapContentHeight(),
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomEnd = if (isUser) 4.dp else 16.dp,
                            bottomStart = if (isUser) 16.dp else 4.dp
                        )
                    ) {
                        Column(
                            Modifier.padding(8.dp),
                        ) Content@{
                            val textIterable = content.parts.filterIsInstance<TextPart>()
                            if (textIterable.isNotEmpty()) {
                                content.parts.filterIsInstance<TextPart>().forEach {
                                    val text =
                                        if (it.text.last() == '\n') it.text.dropLast(1) else it.text
                                    Text(text = text)
                                }
                            }

                            val imageIterable = content.parts.filterIsInstance<ImagePart>()
                            if (imageIterable.isEmpty()) return@Content
                            LazyRow(
                                Modifier
//                                    .fillMaxWidth()
                                    .height(150.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                contentPadding = PaddingValues(8.dp)
                            ) {
                                items(imageIterable) {
                                    Image(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .clip(RoundedCornerShape(8.dp)),
                                        bitmap = it.image.asImageBitmap(),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillHeight
                                    )
                                }
                            }
//                                    parts.filterIsInstance<ImagePart>().forEach {
//                                        Image(it.image.asImageBitmap(), null)
//                                    }
                        }
                    }
                }
            }
        }

        ElevatedCard(onClick = {
            isShowingDialog = true
        }, modifier = Modifier.align(Alignment.End)) {
            AnimatedContent(targetState = bakingViewModel.currModel) {
                Text(it.name, modifier = Modifier.padding(8.dp))
            }
            DropdownMenu(
                expanded = isShowingDialog,
                onDismissRequest = { isShowingDialog = false }) {
                Model.entries.forEach { model ->
                    DropdownMenuItem(text = { Text(model.name) }, onClick = {
                        bakingViewModel.currModel = model
                        isShowingDialog = false
                    })
                }
            }
        }


        Card {
            Row(verticalAlignment = Alignment.CenterVertically) {
                LazyRow(
                    Modifier
                        .weight(1f)
                        .height(150.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(images) {
                        Image(
                            modifier = Modifier
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(8.dp)),
                            bitmap = it.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Button(onClick = {
                        getImage.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    }) {
                        Text("Image")
                    }

                    Button(onClick = {
                        capture.launch(null)
                    }) {
                        Text("Capture")
                    }
                }
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextField(value = curr, onValueChange = { curr = it }, Modifier.weight(1f))
            Button(onClick = {
                scope.launch {
                    val content = content {
                        if (curr.text.isNotBlank()) {
                            text(curr.text)
                            curr = emptyString
                        }

                        images.forEach {
                            image(it)
                        }
                        images.clear()
                    }
                    list.add(content)

                    val r = model.generateContent(content)
                    r.candidates.forEach {
                        list.add(it.content)
                    }
                }

                focusManager.clearFocus()
            }) {
                Text(text = "Send")
            }
        }
    }


    LaunchedEffect(Unit) {
        Places.initializeWithNewPlacesApiEnabled(context, BuildConfig.MAPS_API_KEY)

        scope.launch {
            val content = content {
                text(prompt)
                curr = emptyString
            }
            list.add(content)

            val r = model.generateContent(content)
            r.candidates.forEach { candidate ->
                list.add(candidate.content)

                candidate.content.parts.filterIsInstance<TextPart>().forEach {
                    val text = if (it.text.last() == '\n') it.text.dropLast(1) else it.text
                    Log.d("!!!", text)

                    // 解析 JSON 字串
                    val plans = parseJson(text)
                    plans?.forEach { plan ->
                        val place = getPlaceDetails(plan.place, BuildConfig.MAPS_API_KEY)
                        Log.d("!!!", place.toString())
                    }
                }
            }
        }
    }
}


private val json = Json { ignoreUnknownKeys = true }
fun parseJson(text: String): List<TravelPlan>? {
    // 移除多餘的字符
    val cleanedText = text.replace("```json", "").replace("```", "").trim()
    return try {
        json.decodeFromString<List<TravelPlan>>(cleanedText)
    } catch (e: Exception) {
        Log.d("!!!", "Json.decodeFromString: $e")
        null
    }
}


val prompt = """
            請給我一份台北兩天一夜的旅遊行程
            請根據上面的描述，期望格式的輸出
  Using this JSON schema:
    ${travelPlanString()}
  Return a `List<TravelPlan>`
  """