package com.example.giminitest.data.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiJsonItem(
    @SerialName("_comment")
    val comment: String? = null,
    @SerialName("llm_output")
    val llmOutput: String? = null,
    @SerialName("plan_data")
    val planData: PlanData? = null,
    @SerialName("system_output")
    val systemOutput: SystemOutput? = null,
    @SerialName("user_input")
    val userInput: String? = null,
    @SerialName("user_interaction")
    val userInteraction: String? = null,
    @SerialName("user_system_input")
    val userSystemInput: UserSystemInput? = null
)

@Serializable
data class PlanData(
    @SerialName("final_plan")
    val finalPlan: String? = null,
    @SerialName("交通資訊")
    val transportationInfo: String? = null
)

@Serializable
data class SystemOutput(
    @SerialName("Youtube_api_output")
    val youtubeApiOutput: List<YoutubeApiOutput>? = null,
    @SerialName("Recommendation")
    val recommendation: List<Recommendation>? = null,
    @SerialName("system_message")
    val systemMessage: String? = null
)

@Serializable
data class YoutubeApiOutput(
    @SerialName("video_id")
    val videoId: String? = null,
    @SerialName("video_title")
    val videoTitle: String? = null,
    @SerialName("summary")
    val summary: String? = null,
    @SerialName("locations")
    val locations: List<String>? = null
)

@Serializable
data class Recommendation(
    @SerialName("place_id")
    val placeId: String? = null,
    @SerialName("name")
    val name: String? = null
)

@Serializable
data class UserSystemInput(
    @SerialName("interested_locations")
    val interestedLocations: List<Recommendation>? = null
)