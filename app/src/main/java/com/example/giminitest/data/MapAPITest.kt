package com.example.giminitest.data

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


@Serializable
data class Candidate(
    val place_id: String
)

@Serializable
data class FindPlaceResponse(
    val candidates: List<Candidate>,
    val status: String
)

@Serializable
data class AddressComponent(
    val long_name: String,
    val short_name: String,
    val types: List<String>
)

@Serializable
data class Location(
    val lat: Double,
    val lng: Double
)

@Serializable
data class Viewport(
    val northeast: Location,
    val southwest: Location
)

@Serializable
data class Geometry(
    val location: Location,
    val viewport: Viewport
)

@Serializable
data class Period(
    val close: OpenCloseTime,
    val open: OpenCloseTime
)

@Serializable
data class OpenCloseTime(
    val day: Int,
    val time: String
)

@Serializable
data class OpeningHours(
    val open_now: Boolean,
    val periods: List<Period>,
    val weekday_text: List<String>
)

@Serializable
data class Photo(
    val height: Int,
    val html_attributions: List<String>,
    val photo_reference: String,
    val width: Int
)

@Serializable
data class PlusCode(
    val compound_code: String,
    val global_code: String
)

@Serializable
data class Review(
    val author_name: String,
    val author_url: String,
    val language: String,
    val profile_photo_url: String,
    val rating: Int,
    val relative_time_description: String,
    val text: String,
    val time: Long
)

@Serializable
data class PlaceResult(
    val address_components: List<AddressComponent>? = null,
    val adr_address: String? = null,
    val business_status: String? = null,
    val formatted_address: String,
    val formatted_phone_number: String? = null,
    val geometry: Geometry,
    val icon: String? = null,
    val icon_background_color: String? = null,
    val icon_mask_base_uri: String? = null,
    val international_phone_number: String? = null,
    val name: String,
    val opening_hours: OpeningHours? = null,
    val photos: List<Photo>? = null,
    val place_id: String,
    val plus_code: PlusCode? = null,
    val rating: Double? = null,
    val reference: String? = null,
    val reviews: List<Review>? = null,
    val types: List<String>? = null,
    val url: String? = null,
    val user_ratings_total: Int? = null,
    val utc_offset: Int? = null,
    val vicinity: String? = null,
    val website: String? = null
)

@Serializable
data class PlaceDetailsResponse(
    val result: PlaceResult,
    val status: String
)

suspend fun getPlaceDetails(query: String, apiKey: String): PlaceResult? {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    val findPlaceUrl = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json"
    val placeDetailsUrl = "https://maps.googleapis.com/maps/api/place/details/json"

    try {
        // Step 1: Find Place API
        val findPlaceResponse: FindPlaceResponse = client.get(findPlaceUrl) {
            parameter("input", query)
            parameter("inputtype", "textquery")
            parameter("fields", "place_id")
            parameter("key", apiKey)
        }.body()

        if (findPlaceResponse.status == "OK" && findPlaceResponse.candidates.isNotEmpty()) {
            val placeId = findPlaceResponse.candidates.first().place_id

            // Step 2: Place Details API
            val placeDetailsResponse: PlaceDetailsResponse = client.get(placeDetailsUrl) {
                parameter("place_id", placeId)
                parameter("fields", "name,rating,formatted_phone_number,formatted_address,geometry,opening_hours,website,address_components,photos,place_id,plus_code,reviews,types,url,user_ratings_total,utc_offset,vicinity,business_status,icon,icon_background_color,icon_mask_base_uri,international_phone_number")
                parameter("key", apiKey)
            }.body()

            if (placeDetailsResponse.status == "OK") {
                return placeDetailsResponse.result
            }
        }
    } finally {
        client.close()
    }

    return null
}
