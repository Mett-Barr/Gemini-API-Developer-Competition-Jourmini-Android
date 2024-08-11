package com.example.giminitest.data.json

import android.util.Log
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
import kotlinx.serialization.json.Json

suspend fun morePlace(
    threadId: String,
    list: List<LocationInfoBasic>
): S1enItem {
    val r = ChatContinueRequest(
        threadId = threadId,
        locationBasicInfo = list
    )
    Log.d("!!!", "planning: request\n$r")

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })  // 安裝JSON支持
        }
    }

    val url = "https://langraphagent-production.up.railway.app/api/v1/llm/chat/continue"

    try {
        // 發送POST請求
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(r)
        }
        val responseBody: S1enItem = response.body()

        Log.d("!!!", "planning: responseBody\n$responseBody")

        return responseBody
    } catch (e: Exception) {
        Log.d("!!!", "Error occurred: ${e.message}")
    } finally {
        client.close()  // 關閉HttpClient
    }
    return S1enItem()
}

suspend fun userInput(
    threadId: String,
    userInteraction: String,
): S1enItem {
    val r = ChatContinueRequest(
        threadId = threadId,
        userInteraction = userInteraction
    )
    Log.d("!!!", "planning: request\n$r")

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })  // 安裝JSON支持
        }
    }

    val url = "https://langraphagent-production.up.railway.app/api/v1/llm/chat/continue"

    try {
        // 發送POST請求
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(r)
        }
        val responseBody: S1enItem = response.body()

        Log.d("!!!", "planning: responseBody\n$responseBody")

        return responseBody
    } catch (e: Exception) {
        Log.d("!!!", "Error occurred: ${e.message}")
    } finally {
        client.close()  // 關閉HttpClient
    }
    return S1enItem()
}

suspend fun done(
    threadId: String,
): S1enItem {
    val r = ChatContinueRequest(
        threadId = threadId,
        userInteraction = "幫我規劃"
    )
    Log.d("!!!", "planning: request\n$r")

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })  // 安裝JSON支持
        }
    }

    val url = "https://langraphagent-production.up.railway.app/api/v1/llm/chat/continue"

    try {
        // 發送POST請求
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(r)
        }
        val responseBody: S1enItem = response.body()

        Log.d("!!!", "planning: responseBody\n$responseBody")

        return responseBody
    } catch (e: Exception) {
        Log.d("!!!", "Error occurred: ${e.message}")
    } finally {
        client.close()  // 關閉HttpClient
    }
    return S1enItem()
}