package com.asadullah.api.request.image.jsonadapter

import com.asadullah.api.request.image.CreateImageVariationRequest
import com.asadullah.enums.ImageSize
import com.asadullah.enums.ResponseFormat
import com.squareup.moshi.*

class CreateImageVariationRequestJsonAdapter : JsonAdapter<CreateImageVariationRequest>() {

    @FromJson
    override fun fromJson(reader: JsonReader): CreateImageVariationRequest {
        var imageRequestWithImage = CreateImageVariationRequest("")
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "image" -> imageRequestWithImage = imageRequestWithImage.copy(
                    image = reader.nextString()
                )
                "n" -> imageRequestWithImage = imageRequestWithImage.copy(
                    numberOfImagesToGenerate = reader.nextInt()
                )
                "size" -> imageRequestWithImage = imageRequestWithImage.copy(
                    size = ImageSize.getImageSizeFromStringSize(reader.nextString())
                )
                "response_format" -> imageRequestWithImage = imageRequestWithImage.copy(
                    responseFormat = ResponseFormat.getResponseFormatFromStringFormat(reader.nextString())
                )
                "user" -> imageRequestWithImage = imageRequestWithImage.copy(
                    userId = reader.nextString()
                )
            }
        }
        reader.endObject()
        return imageRequestWithImage
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: CreateImageVariationRequest?) {
        writer
            .beginObject()
            .name("image").value(value?.image)
            .name("n").value(value?.numberOfImagesToGenerate)
            .name("size").value(value?.size?.size)
            .name("response_format").value(value?.responseFormat?.format)
            .name("user").value(value?.userId)
            .endObject()
    }
}