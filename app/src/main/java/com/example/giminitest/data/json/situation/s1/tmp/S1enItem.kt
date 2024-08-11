package com.example.giminitest.data.json.situation.s1.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class S1enItem(
    @SerialName("itinerary")
    val itinerary: String? = null,
    @SerialName("lnode")
    val lnode: String? = null,
    @SerialName("location_info")
    val locationInfo: List<LocationInfo?>? = null,
    @SerialName("messages")
    val messages: List<Message?>? = null,
    @SerialName("place_id")
    val placeId: String? = null,
    @SerialName("place_name")
    val placeName: String? = null,
    @SerialName("plan_options")
    val planOptions: String? = null,
    @SerialName("user_input")
    val userInput: List<String?>? = null,
    @SerialName("user_message")
    val userMessage: String? = null,
    @SerialName("video_info")
    val videoInfo: List<VideoInfo?>? = null
)