package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetModelsResponse(
    @Json(name = "data")
    val `data`: List<Model>,
    @Json(name = "object")
    val objectX: String
)