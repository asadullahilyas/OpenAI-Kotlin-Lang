package com.asadullah.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FineTune(
    @Json(name = "created_at")
    val createdAt: Int,
    @Json(name = "events")
    val events: List<Event>?,
    @Json(name = "fine_tuned_model")
    val fineTunedModel: String,
    @Json(name = "hyperparams")
    val hyperparams: HyperParams,
    @Json(name = "id")
    val id: String,
    @Json(name = "model")
    val model: String,
    @Json(name = "object")
    val objectX: String,
    @Json(name = "organization_id")
    val organizationId: String,
    @Json(name = "result_files")
    val resultFiles: List<FineTuneFile>,
    @Json(name = "status")
    val status: String,
    @Json(name = "training_files")
    val trainingFiles: List<FineTuneFile>,
    @Json(name = "updated_at")
    val updatedAt: Int,
    @Json(name = "validation_files")
    val validationFiles: List<FineTuneFile>
) {
    @JsonClass(generateAdapter = true)
    data class Event(
        @Json(name = "created_at")
        val createdAt: Int,
        @Json(name = "level")
        val level: String,
        @Json(name = "message")
        val message: String,
        @Json(name = "object")
        val objectX: String
    )

    @JsonClass(generateAdapter = true)
    data class HyperParams(
        @Json(name = "batch_size")
        val batchSize: Int,
        @Json(name = "learning_rate_multiplier")
        val learningRateMultiplier: Double,
        @Json(name = "n_epochs")
        val nEpochs: Int,
        @Json(name = "prompt_loss_weight")
        val promptLossWeight: Double
    )

    @JsonClass(generateAdapter = true)
    data class FineTuneFile(
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
}