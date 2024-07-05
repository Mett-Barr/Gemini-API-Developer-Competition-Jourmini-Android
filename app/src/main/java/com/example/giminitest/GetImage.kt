package com.example.giminitest

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun selectImageAndGetBitmap(context: Context): Bitmap? {
    val activity = context as? ComponentActivity
        ?: throw IllegalArgumentException("Context must be AppCompatActivity")

//    val deferred = CompletableDeferred<Bitmap?>()
    val deferredUri = CompletableDeferred<Uri?>()
    val getContent: ActivityResultLauncher<String> = activity.registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        deferredUri.complete(uri)
    }

    getContent.launch("image/*")

    val uri = deferredUri.await()
    return uriToBitmap(context, uri ?: return null)

//    deferred.complete(bitmap)
//    return deferred.await()
}

suspend fun uriToBitmap(context: Context, uri: Uri): Bitmap? = withContext(Dispatchers.IO) {
    return@withContext context.contentResolver.openInputStream(uri)?.use { inputStream ->
        BitmapFactory.decodeStream(inputStream)
    }
}