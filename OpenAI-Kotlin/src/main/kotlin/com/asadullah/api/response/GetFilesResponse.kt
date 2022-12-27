package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetFilesResponse(
    @Json(name = "data")
    val `data`: List<FileResponse>,
    @Json(name = "object")
    val objectX: String
)