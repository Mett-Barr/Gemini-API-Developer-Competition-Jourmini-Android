package com.example.giminitest.map

import android.util.Log
import com.google.android.libraries.places.api.model.PhotoMetadata
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient


fun photoMetadataTest(placesClient: PlacesClient, placeId: String) {
    val placeFields = listOf(Place.Field.ID, Place.Field.PHOTO_METADATAS)
    val request = FetchPlaceRequest.builder(placeId, placeFields).build()

    placesClient.fetchPlace(request)
        .addOnSuccessListener { response ->
            val place = response.place

            val photoMetadataList = place.photoMetadatas

        }
        .addOnFailureListener { exception ->
            // 处理错误
            Log.e("Places API Demo", "Place request failed: ${exception.message}")
        }
}

fun photoTest(placesClient: PlacesClient, photoMetadata: PhotoMetadata) {
    // 创建 FetchPhotoRequest
    val photoRequest = FetchPhotoRequest.builder(photoMetadata)
        .setMaxWidth(400)
        .setMaxHeight(300)
        .build()

    placesClient.fetchPhoto(photoRequest)
        .addOnSuccessListener { photoMetadataResponse ->
            val bitmap = photoMetadataResponse.bitmap
        }
        .addOnFailureListener { exception ->
            // 處理錯誤
            Log.e("Places API Demo", "Place photo request failed: ${exception.message}")
        }
}

