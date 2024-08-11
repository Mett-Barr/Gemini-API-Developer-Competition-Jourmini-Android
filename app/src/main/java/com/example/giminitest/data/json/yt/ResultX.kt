package com.example.giminitest.data.json.yt


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultX(
    @SerialName("video_id")
    val videoId: String,
    @SerialName("video_title")
    val videoTitle: String
)