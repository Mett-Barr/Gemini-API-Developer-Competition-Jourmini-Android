package com.example.giminitest.data.json.situation.s3.s3_3


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class S3_3(
    @SerialName("extract_locations")
    val extractLocations: ExtractLocations
)