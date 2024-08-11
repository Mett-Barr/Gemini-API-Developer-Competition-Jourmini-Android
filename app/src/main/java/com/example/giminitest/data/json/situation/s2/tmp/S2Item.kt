package com.example.giminitest.data.json.situation.s2.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class S2Item(
    @SerialName("itinerary")
    val itinerary: String? = null,
    @SerialName("location_info")
    val locationInfo: List<LocationInfo?>? = null,
    @SerialName("plan_option")
    val planOption: String? = null,
    @SerialName("plan_options")
    val planOptions: String? = null,
    @SerialName("user_interaction")
    val userInteraction: List<UserInteraction?>? = null,
    @SerialName("user_message")
    val userMessage: String? = null,
    @SerialName("video_info")
    val videoInfo: List<VideoInfo?>? = null
)