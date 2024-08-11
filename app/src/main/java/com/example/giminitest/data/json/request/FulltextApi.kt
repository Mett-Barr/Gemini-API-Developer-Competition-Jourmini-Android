package com.example.giminitest.data.json.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FulltextApi(
    @SerialName("locations")
    val locations: List<String>,
    @SerialName("semanticRatio")
    val semanticRatio: Double,
    @SerialName("top_n")
    val topN: Int
)