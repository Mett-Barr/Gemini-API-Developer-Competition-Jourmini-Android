package com.example.giminitest.data.json.situation.s2.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInteraction(
    @SerialName("place_id")
    val placeId: String? = null,
    @SerialName("place_name")
    val placeName: String? = null
)