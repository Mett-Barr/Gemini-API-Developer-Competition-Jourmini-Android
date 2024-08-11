package com.example.giminitest.data.json.yt


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("results")
    val results: List<ResultX>
)