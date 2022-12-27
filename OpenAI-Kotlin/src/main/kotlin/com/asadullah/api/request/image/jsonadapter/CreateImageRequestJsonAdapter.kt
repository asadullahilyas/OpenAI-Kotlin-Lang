package com.asadullah.api.request.image.jsonadapter

import com.asadullah.api.request.image.CreateImageRequest
import com.asadullah.enums.ImageSize
import com.asadullah.enums.ResponseFormat
import com.squareup.moshi.*

class CreateImageRequestJsonAdapter : JsonAdapter<CreateImageRequest>() {

    @FromJson
    override fun fromJson(reader: JsonReader): CreateImageRequest {
        var imageRequestWithPrompt = CreateImageRequest("")
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "prompt" -> imageRequestWithPrompt = imageRequestWithPrompt.copy(
                    prompt = reader.nextString()
                )
                "n" -> imageRequestWithPrompt = imageRequestWithPrompt.copy(
                    numberOfImagesToGenerate = reader.nextInt()
                )
                "size" -> imageRequestWithPrompt = imageRequestWithPrompt.copy(
                    size = ImageSize.getImageSizeFromStringSize(reader.nextString())
                )
                "response_format" -> imageRequestWithPrompt = imageRequestWithPrompt.copy(
                    responseFormat = ResponseFormat.getResponseFormatFromStringFormat(reader.nextString())
                )
                "user" -> imageRequestWithPrompt = imageRequestWithPrompt.copy(
                    userId = reader.nextString()
                )
            }
        }
        reader.endObject()
        return imageRequestWithPrompt
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: CreateImageRequest?) {
        writer
            .beginObject()
            .name("prompt").value(value?.prompt)
            .name("n").value(value?.numberOfImagesToGenerate)
            .name("size").value(value?.size?.size)
            .name("response_format").value(value?.responseFormat?.format)
            .name("user").value(value?.userId)
            .endObject()
    }
}