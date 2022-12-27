package com.asadullah.api.request.moderation

import com.asadullah.enums.TextModeration
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class CreateModerationRequest(

    /**
     * The input text to classify.
     */
    @Json(name = "input")
    val input: List<String>,

    /**
     * Two content moderation models are available: Stable and Latest.
     *
     * The default is Latest which will be automatically upgraded over time.
     * This ensures you are always using OpenAI's most accurate model. If you
     * use Stable, OpenAI will provide advanced notice before updating the model.
     * Accuracy of Stable may be slightly lower than for Latest.
     */
    @Json(name = "model")
    val textModerationModel: TextModeration = TextModeration.Latest
)
