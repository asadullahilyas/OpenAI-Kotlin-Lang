package com.asadullah.api.request.image.jsonadapter

import com.asadullah.api.request.image.EditImageRequest
import com.asadullah.enums.ImageSize
import com.asadullah.enums.ResponseFormat
import com.squareup.moshi.*

class EditImageRequestJsonAdapter : JsonAdapter<EditImageRequest>() {

    @FromJson
    override fun fromJson(reader: JsonReader): EditImageRequest {
        var imageRequestEdit = EditImageRequest(image = "", prompt = "")
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "prompt" -> imageRequestEdit = imageRequestEdit.copy(
                    prompt = reader.nextString()
                )
                "image" -> imageRequestEdit = imageRequestEdit.copy(
                    prompt = reader.nextString()
                )
                "mask" -> imageRequestEdit = imageRequestEdit.copy(
                    prompt = reader.nextString()
                )
                "n" -> imageRequestEdit = imageRequestEdit.copy(
                    numberOfImagesToGenerate = reader.nextInt()
                )
                "size" -> imageRequestEdit = imageRequestEdit.copy(
                    size = ImageSize.getImageSizeFromStringSize(reader.nextString())
                )
                "response_format" -> imageRequestEdit = imageRequestEdit.copy(
                    responseFormat = ResponseFormat.getResponseFormatFromStringFormat(reader.nextString())
                )
                "user" -> imageRequestEdit = imageRequestEdit.copy(
                    userId = reader.nextString()
                )
            }
        }
        reader.endObject()
        return imageRequestEdit
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: EditImageRequest?) {
        writer
            .beginObject()
            .name("prompt").value(value?.prompt)
            .name("image").value(value?.image)
            .name("mask").value(value?.mask)
            .name("n").value(value?.numberOfImagesToGenerate)
            .name("size").value(value?.size?.size)
            .name("response_format").value(value?.responseFormat?.format)
            .name("user").value(value?.userId)
            .endObject()
    }
}