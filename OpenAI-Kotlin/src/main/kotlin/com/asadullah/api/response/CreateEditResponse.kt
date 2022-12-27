package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateEditResponse(
    @Json(name = "choices")
    val choices: List<Choice>,
    @Json(name = "created")
    val created: Int,
    @Json(name = "object")
    val objectX: String,
    @Json(name = "usage")
    val usage: Usage
) {
    @JsonClass(generateAdapter = true)
    data class Choice(
        @Json(name = "index")
        val index: Int,
        @Json(name = "text")
        val text: String
    )

    @JsonClass(generateAdapter = true)
    data class Usage(
        @Json(name = "completion_tokens")
        val completionTokens: Int,
        @Json(name = "prompt_tokens")
        val promptTokens: Int,
        @Json(name = "total_tokens")
        val totalTokens: Int
    )
}