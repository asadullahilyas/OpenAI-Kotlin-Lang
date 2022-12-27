package com.asadullah.api.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateCompletionRequest(

    /**
     * ID of the model to use. You can use the List models API to see all of your
     * available models.
     */
    @Json(name = "model")
    val modelId: String,

    /**
     * The prompt(s) to generate completions for, encoded as a string, array of strings,
     * array of tokens, or array of token arrays.
     */
    @Json(name = "prompt")
    val prompt: List<String>? = null,

    /**
     * The suffix that comes after a completion of inserted text.
     */
    @Json(name = "suffix")
    val suffix: String? = null,

    /**
     * The maximum number of tokens to generate in the completion.
     *
     * The token count of your prompt plus maxTokens cannot exceed the model's context length.
     * Most models have a context length of 2048 tokens (except for the newest models, which
     * support 4096).
     */
    @Json(name = "max_tokens")
    val maxTokens: Int? = null,

    /**
     * What sampling temperature to use. Higher values means the model will take more risks.
     * Try 0.9 for more creative applications, and 0 (argmax sampling) for ones with a
     * well-defined answer.
     *
     * OpenAI generally recommends altering this or topP but not both.
     */
    @Json(name = "temperature")
    val temperature: Float? = null,

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model
     * considers the results of the tokens with top_p probability mass. So 0.1 means only
     * the tokens comprising the top 10% probability mass are considered.
     *
     * OpenAI generally recommends altering this or temperature but not both.
     */
    @Json(name = "top_p")
    val topP: Float? = null,

    /**
     * How many completions to generate for each prompt.
     *
     * Note: Because this parameter generates many completions, it can quickly consume
     * your token quota. Use carefully and ensure that you have reasonable settings
     * for maxTokens and stop.
     */
    @Json(name = "n")
    val numberOfCompletionsToGenerate: Int? = null,

    /**
     * Whether to stream back partial progress. If set, tokens will be sent as
     * data-only server-sent events as they become available, with the stream terminated
     * by a data: [DONE] message.
     */
    @Json(name = "stream")
    val stream: Boolean = false,


    /**
     * Include the log probabilities on the most likely tokens, as well the chosen tokens.
     * For example, if logProbabilities is 5, the API will return a list of the 5 most
     * likely tokens. The API will always return the logProbabilities of the sampled token,
     * so there may be up to logProbabilities+1 elements in the response.
     *
     * The maximum value for logProbabilities is 5. If you need more than this, please contact
     * OpenAI through their Help center.
     */
    @Json(name = "logprobs")
    val logProbabilities: Int? = null,

    /**
     * Echo back the prompt in addition to the completion
     */
    @Json(name = "echo")
    val echo: Boolean = false,

    /**
     * Up to 4 sequences where the API will stop generating further tokens. The returned
     * text will not contain the stop sequence.
     */
    @Json(name = "stop")
    val stop: List<String>? = null,

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether
     * they appear in the text so far, increasing the model's likelihood to talk about new topics.
     */
    @Json(name = "presence_penalty")
    val presencePenalty: Float? = null,

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their
     * existing frequency in the text so far, decreasing the model's likelihood to
     * repeat the same line verbatim.
     */
    @Json(name = "frequency_penalty")
    val frequencyPenalty: Float? = null,

    /**
     * Generates bestOf completions server-side and returns the "best" (the one with
     * the highest log probability per token). Results cannot be streamed.
     *
     * When used with numberOfCompletionsToGenerate, bestOf controls the number of
     * candidate completions and numberOfCompletionsToGenerate specifies how many to
     * return – bestOf must be greater than numberOfCompletionsToGenerate.
     *
     * Note: Because this parameter generates many completions, it can quickly consume
     * your token quota. Use carefully and ensure that you have reasonable settings
     * for maxTokens and stop.
     */
    @Json(name = "best_of")
    val bestOf: Int? = null,

    /**
     * Modify the likelihood of specified tokens appearing in the completion.
     *
     * Accepts a json object that maps tokens (specified by their token ID in the GPT
     * tokenizer) to an associated bias value from -100 to 100. You can use this tokenizer
     * tool (which works for both GPT-2 and GPT-3) to convert text to token IDs.
     * Mathematically, the bias is added to the logits generated by the model prior to
     * sampling. The exact effect will vary per model, but values between -1 and 1 should
     * decrease or increase likelihood of selection; values like -100 or 100 should result
     * in a ban or exclusive selection of the relevant token.
     */
    @Json(name = "logit_bias")
    val logitBias: Map<String, Int> = emptyMap(),

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     */
    @Json(name = "user")
    val userId: String? = null
)