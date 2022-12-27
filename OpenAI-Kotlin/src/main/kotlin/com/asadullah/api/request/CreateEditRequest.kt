package com.asadullah.api.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateEditRequest(

    /**
     * ID of the model to use. You can use the List models API to see all of your
     * available models.
     */
    @Json(name = "model")
    val modelId: Int,

    /**
     * The instruction that tells the model how to edit the prompt.
     */
    @Json(name = "instruction")
    val instruction: String,

    /**
     * The input text to use as a starting point for the edit.
     */
    @Json(name = "input")
    val input: String? = null,

    /**
     * How many edits to generate for the input and instruction.
     */
    @Json(name = "n")
    val numberOfEditsToGenerate: Int? = null,

    /**
     * What sampling temperature to use. Higher values means the model will take more
     * risks. Try 0.9 for more creative applications, and 0 (argmax sampling) for ones
     * with a well-defined answer.
     *
     * OpenAI generally recommends altering this or topP but not both.
     */
    @Json(name = "temperature")
    val temperature: Float? = null,

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where
     * the model considers the results of the tokens with top_p probability mass.
     * So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     *
     * OpenAI generally recommends altering this or temperature but not both.
     */
    @Json(name = "top_p")
    val topP: Float? = null
)
