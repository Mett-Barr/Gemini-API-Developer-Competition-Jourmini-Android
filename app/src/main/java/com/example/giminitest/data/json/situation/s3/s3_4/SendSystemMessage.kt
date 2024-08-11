package com.example.giminitest.data.json.situation.s3.s3_4


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SendSystemMessage(
    @SerialName("lnode")
    val lnode: String
)