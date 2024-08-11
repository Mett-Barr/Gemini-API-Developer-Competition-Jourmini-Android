package com.example.giminitest.data.json.situation.s3.s3_4


import android.util.Log
import com.example.giminitest.data.json.situation.s3.s3_2.S3_2
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class S3_4(
    @SerialName("send_system_message")
    val sendSystemMessage: SendSystemMessage
)



private val fakeJsonString = """{'send_system_message': {'lnode': 'system_message'}}""".trimIndent().replace("'", "\"")

private val fakeJsonObject: S3_4 by lazy {
    Json.decodeFromString(fakeJsonString)
}

fun S3_4test() {
    Log.d("!!!", "S3_2test: $fakeJsonObject")
}