package com.example.giminitest.data.json.situation.s3.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Day2(
    @SerialName("photo_url")
    val photoUrl: String? = "",
    @SerialName("place_address")
    val placeAddress: String? = "",
    @SerialName("place_coordinates")
    val placeCoordinates: PlaceCoordinates? = PlaceCoordinates(),
    @SerialName("place_id")
    val placeId: String? = "",
    @SerialName("place_name")
    val placeName: String? = ""
)