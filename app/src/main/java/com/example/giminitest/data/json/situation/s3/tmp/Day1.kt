package com.example.giminitest.data.json.situation.s3.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Day1(
    @SerialName("photo_url")
    val photoUrl: String? = null,
    @SerialName("place_address")
    val placeAddress: String? = null,
    @SerialName("place_coordinates")
    val placeCoordinates: PlaceCoordinates? = null,
    @SerialName("place_id")
    val placeId: String? = null,
    @SerialName("place_name")
    val placeName: String? = null
)