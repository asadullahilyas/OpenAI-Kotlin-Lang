package com.asadullah.api.request.image

import com.asadullah.enums.ImageSize
import com.asadullah.enums.ResponseFormat
import com.squareup.moshi.*
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

@JsonClass(generateAdapter = false)
data class EditImageRequest(

    /**
     * A text description of the desired image(s). The maximum length
     * is 1000 characters.
     */
    @Json(name = "prompt")
    val prompt: String,

    /**
     * The image to edit. Must be a valid PNG file, less than 4MB,
     * and square. If mask is not provided, image must have transparency,
     * which will be used as the mask.
     */
    @Json(name = "image")
    val image: String,


    /**
     * An additional image whose fully transparent areas (e.g. where alpha
     * is zero) indicate where image should be edited. Must be a valid PNG
     * file, less than 4MB, and have the same dimensions as image.
     */
    @Json(name = "mask")
    val mask: String? = null,

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
) {
    fun toRequestBodyMap(): Map<String, RequestBody> {

        val map = mutableMapOf<String, RequestBody>()
        map["prompt"] = prompt.toRequestBody()
        map["image"] = File(image).asRequestBody()
        if (mask != null) map["mask"] = File(mask).asRequestBody()
        if (numberOfImagesToGenerate != null) map["n"] = numberOfImagesToGenerate.toString().toRequestBody()
        if (size != null) map["size"] = size.size.toRequestBody()
        if (responseFormat != null) map["response_format"] = responseFormat.format.toRequestBody()
        if (userId != null) map["user"] = userId.toRequestBody()

        return map
    }
}