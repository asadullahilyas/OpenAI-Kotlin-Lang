package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Model(
    @Json(name = "created")
    val created: Int,
    @Json(name = "id")
    val id: String,
    @Json(name = "object")
    val objectX: String,
    @Json(name = "owned_by")
    val ownedBy: String,
    @Json(name = "parent")
    val parent: Any?,
    @Json(name = "permission")
    val permission: List<Permission>,
    @Json(name = "root")
    val root: String
) {
    @JsonClass(generateAdapter = true)
    data class Permission(
        @Json(name = "allow_create_engine")
        val allowCreateEngine: Boolean,
        @Json(name = "allow_fine_tuning")
        val allowFineTuning: Boolean,
        @Json(name = "allow_logprobs")
        val allowLogprobs: Boolean,
        @Json(name = "allow_sampling")
        val allowSampling: Boolean,
        @Json(name = "allow_search_indices")
        val allowSearchIndices: Boolean,
        @Json(name = "allow_view")
        val allowView: Boolean,
        @Json(name = "created")
        val created: Int,
        @Json(name = "group")
        val group: Any?,
        @Json(name = "id")
        val id: String,
        @Json(name = "is_blocking")
        val isBlocking: Boolean,
        @Json(name = "object")
        val objectX: String,
        @Json(name = "organization")
        val organization: String
    )
}