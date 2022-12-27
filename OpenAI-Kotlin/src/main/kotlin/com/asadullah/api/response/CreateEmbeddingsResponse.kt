package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateEmbeddingsResponse(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "model")
    val model: String,
    @Json(name = "object")
    val objectX: String,
    @Json(name = "usage")
    val usage: Usage
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "embedding")
        val embedding: List<Double>,
        @Json(name = "index")
        val index: Int,
        @Json(name = "object")
        val objectX: String
    )

    @JsonClass(generateAdapter = true)
    data class Usage(
        @Json(name = "prompt_tokens")
        val promptTokens: Int,
        @Json(name = "total_tokens")
        val totalTokens: Int
    )
}