package com.example.giminitest.data.json.situation.s3.s3_3


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtractLocations(
    @SerialName("lnode")
    val lnode: String,
    @SerialName("locations_json")
    val locationsJson: List<String>
)