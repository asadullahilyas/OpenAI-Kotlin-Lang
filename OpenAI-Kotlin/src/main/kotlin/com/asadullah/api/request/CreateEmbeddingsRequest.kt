package com.asadullah.api.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateEmbeddingsRequest(

    /**
     * ID of the model to use. You can use the List models API
     * to see all of your available models.
     */
    @Json(name = "model")
    val model: String,

    /**
     * Input text to get embeddings for, encoded as a string or
     * array of tokens. To get embeddings for multiple inputs in a
     * single request, pass an array of strings or array of token arrays.
     * Each input must not exceed 8192 tokens in length.
     */
    @Json(name = "input")
    val input: List<String>,

    /**
     * A unique identifier representing your end-user, which can
     * help OpenAI to monitor and detect abuse.
     */
    @Json(name = "user")
    val userId: String? = null
)