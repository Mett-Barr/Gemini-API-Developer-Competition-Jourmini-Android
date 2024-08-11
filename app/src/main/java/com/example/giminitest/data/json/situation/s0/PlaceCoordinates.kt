package com.example.giminitest.data.json.situation.s0


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaceCoordinates(
    @SerialName("latitude")
    val latitude: Double? = null,
    @SerialName("longitude")
    val longitude: Double? = null
)