package com.example.giminitest.data.json.situation.s1.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Message(
    @SerialName("content")
    val content: String? = null,
    @SerialName("type")
    val type: String? = null
)