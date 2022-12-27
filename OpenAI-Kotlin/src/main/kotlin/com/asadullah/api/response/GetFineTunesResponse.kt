package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetFineTunesResponse(
    @Json(name = "data")
    val `data`: List<FineTune>,
    @Json(name = "object")
    val objectX: String
)