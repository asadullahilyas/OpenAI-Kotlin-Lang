package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageResponse(
    @Json(name = "created")
    val created: Int,
    @Json(name = "data")
    val `data`: List<Data>
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "url")
        val url: String? = null,

        @Json(name = "b64_json")
        val base64Json: String? = null
    )
}