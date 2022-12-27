package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeleteFileResponse(
    @Json(name = "deleted")
    val deleted: Boolean,
    @Json(name = "id")
    val id: String,
    @Json(name = "object")
    val objectX: String
)