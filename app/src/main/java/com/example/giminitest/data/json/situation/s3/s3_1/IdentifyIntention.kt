package com.example.giminitest.data.json.situation.s3.s3_1


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdentifyIntention(
    @SerialName("intent")
    val intent: String,
    @SerialName("lnode")
    val lnode: String
)