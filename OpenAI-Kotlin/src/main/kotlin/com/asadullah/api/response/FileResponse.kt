package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FileResponse(
    @Json(name = "bytes")
    val bytes: Int,
    @Json(name = "created_at")
    val createdAt: Int,
    @Json(name = "filename")
    val filename: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "object")
    val objectX: String,
    @Json(name = "purpose")
    val purpose: String
)