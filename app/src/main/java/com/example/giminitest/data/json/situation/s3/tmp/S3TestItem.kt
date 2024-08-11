package com.example.giminitest.data.json.situation.s3.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class S3TestItem(
    @SerialName("google_traffic")
    val googleTraffic: GoogleTraffic? = GoogleTraffic(),
    @SerialName("itinerary")
    val itinerary: String? = "",
    @SerialName("location_info")
    val locationInfo: List<LocationInfo>? = listOf(),
    @SerialName("place_id")
    val placeId: String? = "",
    @SerialName("place_name")
    val placeName: String? = "",
    @SerialName("plan_options")
    val planOptions: String? = "",
    @SerialName("trip_plan")
    val tripPlan: String? = "",
    @SerialName("user_message")
    val userMessage: String? = "",
    @SerialName("video_info")
    val videoInfo: List<VideoInfo>? = listOf()
)