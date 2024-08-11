package com.example.giminitest.data.json.situation.s2.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoInfo(
    @SerialName("video_id")
    val videoId: String? = null,
    @SerialName("video_title")
    val videoTitle: String? = null
)