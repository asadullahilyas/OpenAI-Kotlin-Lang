package com.asadullah.api.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

@JsonClass(generateAdapter = true)
data class UploadFileRequest(

    /**
     * Name of the JSON Lines file to be uploaded.
     *
     * If the purpose is set to "fine-tune", each line is a JSON
     * record with "prompt" and "completion" fields representing
     * your training examples.
     */
    @Json(name = "file")
    val file: String,

    /**
     * The intended purpose of the uploaded documents.
     *
     * Use "fine-tune" for Fine-tuning. This allows us to validate
     * the format of the uploaded file.
     */
    @Json(name = "purpose")
    val purpose: String
) {
    fun toRequestBodyMap(): Map<String, RequestBody> {
        return mapOf(
            "file" to File(file).asRequestBody(),
            "purpose" to purpose.toRequestBody()
        )
    }
}
