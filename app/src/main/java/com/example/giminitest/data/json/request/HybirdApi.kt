package com.example.giminitest.data.json.request


//import io.ktor.client.features.*
//import io.ktor.client.features.json.*
//import io.ktor.client.features.json.serializer.*
//import io.ktor.client.features.logging.*
import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class HybridApiResponse(
    @SerialName("results")
    val results: List<ResultItem>
)

@Serializable
data class ResultItem(
    @SerialName("locations")
    val locations: List<String>,
    @SerialName("semanticRatio")
    val semanticRatio: Double,
    @SerialName("top_n")
    val topN: Int
)

@Serializable
data class HybridApiRequest(
    @SerialName("locations")
    val locations: List<String>,
    @SerialName("semanticRatio")
    val semanticRatio: Double,
    @SerialName("top_n")
    val topN: Int
)


@Serializable
data class HybridApi(
    @SerialName("locations")
    val locations: List<String>,
    @SerialName("semanticRatio")
    val semanticRatio: Double,
    @SerialName("top_n")
    val topN: Int
) {
    companion object {
        suspend fun fetchHybridApiData(): HybridApiResponse? {
            val client = HttpClient(CIO) {
                install(ContentNegotiation) {
                    json()
                }
                defaultRequest {
                    header("Accept", "application/json")
                }
            }

            val requestBody = HybridApiRequest(
                locations = listOf("string"),
                semanticRatio = 0.5,
                topN = 3
            )

            return try {
                val response: HybridApiResponse =
                    client.post("https://langraphagent-production.up.railway.app/api/v1/search/hybrid/multi/") {
                        url {
                            parameters.append("index_uid", "youtube_full_context_videos")
                        }
                        contentType(ContentType.Application.Json)
                        setBody(requestBody)
                    }.body()
                response
            } catch (e: Exception) {
                println("Error: ${e.message}")
                null
            } finally {
                client.close()
            }
        }
    }
}