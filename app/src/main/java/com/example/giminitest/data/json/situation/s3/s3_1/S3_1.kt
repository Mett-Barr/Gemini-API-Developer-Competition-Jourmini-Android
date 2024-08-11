package com.example.giminitest.data.json.situation.s3.s3_1


import android.util.Log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class S3_1(
    @SerialName("identify_intention")
    val identifyIntention: IdentifyIntention
)

private val fakeJsonString = """
    {'identify_intention': {'intent': 'options path \n', 'lnode': 'identify_intention'}}
""".trimIndent().replace("'", "\"")

private val fakeJsonObject: S3_1 by lazy {
    Json.decodeFromString(fakeJsonString)
}

fun S3_1test() {
    Log.d("!!!", "S3_1test: $fakeJsonObject")
}
