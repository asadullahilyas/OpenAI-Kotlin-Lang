package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetEventsByFineTuneIdResponse(
    @Json(name = "data")
    val `data`: List<FineTune.Event>,
    @Json(name = "object")
    val objectX: String
)