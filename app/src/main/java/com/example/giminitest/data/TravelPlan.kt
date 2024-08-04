package com.example.giminitest.data

import kotlinx.serialization.Serializable

@Serializable
data class TravelPlan(
    val day: Int,
    val time: Int,
    val place: String
)

fun travelPlanString(): String = "TravelPlan = {\"day\": number, \"time\": number, \"place\": string,}"