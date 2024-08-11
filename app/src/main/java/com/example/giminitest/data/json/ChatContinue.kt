package com.example.giminitest.data.json

import android.util.Log
import com.example.giminitest.Route
import com.example.giminitest.data.json.situation.s1.S1Request
import com.example.giminitest.data.json.situation.s1.tmp.S1enItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.random.Random

suspend fun chatContinue(threadId: String, userInteraction: String): S1enItem {
    val id = Random.nextInt().toString()
    val r = ChatContinueResuest(
        threadId = threadId, userInteraction = userInteraction
    )

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })  // 安裝JSON支持
        }
    }

    // API的URL
    val url = "https://langraphagent-production.up.railway.app/api/v1/llm/chat/continue"


    try {
        // 發送POST請求
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(r)
        }
        val responseBody: S1enItem = response.body()

        Log.d("!!!", "SearchPage: responseBody\n$responseBody")

        return responseBody
    } catch (e: Exception) {
        Log.d("!!!", "Error occurred: ${e.message}")
    } finally {
        client.close()  // 關閉HttpClient
    }
    return S1enItem()
}

@Serializable
data class ChatContinueResuest(
    @SerialName("location_basic_info")
    val locationBasicInfo: List<String> = emptyList(),
    @SerialName("thread_id")
    val threadId: String? = null,
    @SerialName("user_interaction")
    val userInteraction: String? = null
)