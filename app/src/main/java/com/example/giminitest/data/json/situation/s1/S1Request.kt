package com.example.giminitest.data.json.situation.s1

import kotlinx.serialization.Serializable


@Serializable
data class S1Request(
    val thread_id: String = "",
    val lang: String? = null,  // 可選字段，默認為null
    val locations: List<String> = emptyList(),  // 默認為空列表
    val user_interaction: String? = null  // 可選字段，默認為null
)
