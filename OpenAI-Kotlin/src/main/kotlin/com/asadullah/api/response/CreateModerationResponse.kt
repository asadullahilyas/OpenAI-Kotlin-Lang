package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateModerationResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "model")
    val model: String,
    @Json(name = "results")
    val results: List<Result>
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "categories")
        val categories: Categories,
        @Json(name = "category_scores")
        val categoryScores: CategoryScores,
        @Json(name = "flagged")
        val flagged: Boolean
    ) {
        @JsonClass(generateAdapter = true)
        data class Categories(
            @Json(name = "hate")
            val hate: Boolean,
            @Json(name = "hate/threatening")
            val hatethreatening: Boolean,
            @Json(name = "self-harm")
            val selfHarm: Boolean,
            @Json(name = "sexual")
            val sexual: Boolean,
            @Json(name = "sexual/minors")
            val sexualminors: Boolean,
            @Json(name = "violence")
            val violence: Boolean,
            @Json(name = "violence/graphic")
            val violencegraphic: Boolean
        )

        @JsonClass(generateAdapter = true)
        data class CategoryScores(
            @Json(name = "hate")
            val hate: Double,
            @Json(name = "hate/threatening")
            val hatethreatening: Double,
            @Json(name = "self-harm")
            val selfHarm: Double,
            @Json(name = "sexual")
            val sexual: Double,
            @Json(name = "sexual/minors")
            val sexualminors: Double,
            @Json(name = "violence")
            val violence: Double,
            @Json(name = "violence/graphic")
            val violencegraphic: Double
        )
    }
}