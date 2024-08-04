package com.example.giminitest.ui.page.main

import android.app.Activity
import android.content.res.Configuration
import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachFile
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.giminitest.uriToBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    Search()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val images = remember { mutableStateListOf<Bitmap>() }

    val getImageLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) {
        scope.launch(Dispatchers.Default) {
            val bitmap = uriToBitmap(context, it ?: return@launch) ?: return@launch
            images.add(bitmap)
        }
    }

    fun getImage() {
        getImageLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    val captureLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) {
        images.add(it ?: return@rememberLauncherForActivityResult)
    }

    fun capture() {
        captureLauncher.launch(null)
    }

    var text by remember { mutableStateOf("") }
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
            text = "Where knowledge begins",
            fillMaxWidth,
            style = MaterialTheme.typography.headlineSmall
        )
        SearchBar(
            modifier = fillMaxWidth,
            query = text,
            onQueryChange = { text = it },
            onSearch = {},
            active = false,
            onActiveChange = {},
            shape = RoundedCornerShape(8.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            },
            windowInsets = WindowInsets(0.dp)
        ) {
            TextField(value = text, onValueChange = { text = it })
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = fillMaxWidth
        ) {
            FilledTonalButton(onClick = { /*TODO*/ }) {
                Row {
                    Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
                }
                Text(text = "Focus")
            }
            FilledTonalButton(onClick = ::getImage) {
                Row {
                    Icon(imageVector = Icons.Rounded.AttachFile, contentDescription = null)
                }
                Text(text = "Attach")
            }
        }
        Spacer(
            Modifier
                .weight(1f)
                .width(150.dp)
        )
    }
}