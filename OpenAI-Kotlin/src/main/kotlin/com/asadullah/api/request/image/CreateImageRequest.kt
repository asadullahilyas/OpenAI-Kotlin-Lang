package com.asadullah.api.request.image

import com.asadullah.enums.ImageSize
import com.asadullah.enums.ResponseFormat
import com.squareup.moshi.*

@JsonClass(generateAdapter = false)
data class CreateImageRequest(

    /**
     * A text description of the desired image(s). The maximum length
     * is 1000 characters.
     */
    @Json(name = "prompt")
    val prompt: String,

    /**
     * The number of images to generate. Must be between 1 and 10.
     */
    @Json(name = "n")
    val numberOfImagesToGenerate: Int? = null,

    /**
     * The size of the generated images.
     */
    @Json(name = "size")
    val size: ImageSize? = null,

    /**
     * The format in which the generated images are returned.
     */
    @Json(name = "response_format")
    val responseFormat: ResponseFormat? = null,

    /**
     * A unique identifier representing your end-user, which can help OpenAI
     * to monitor and detect abuse.
     */
    @Json(name = "user")
    val userId: String? = null
)