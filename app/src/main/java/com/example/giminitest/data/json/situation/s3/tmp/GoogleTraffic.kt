package com.example.giminitest.data.json.situation.s3.tmp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoogleTraffic(
    @SerialName("day_1")
    val day1: List<Day1>? = listOf(),
    @SerialName("day_2")
    val day2: List<Day2>? = listOf(),
    @SerialName("day_3")
    val day3: List<Day2>? = listOf()
)