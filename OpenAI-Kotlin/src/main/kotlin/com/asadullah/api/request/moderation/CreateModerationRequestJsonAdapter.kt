package com.asadullah.api.request.moderation

import com.asadullah.enums.TextModeration
import com.squareup.moshi.*

class CreateModerationRequestJsonAdapter : JsonAdapter<CreateModerationRequest>() {

    @FromJson
    override fun fromJson(reader: JsonReader): CreateModerationRequest {
        var createModerationRequest = CreateModerationRequest(emptyList())
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "input" -> {
                    val inputList = mutableListOf<String>()
                    reader.beginArray()
                    while (reader.hasNext()) {
                        inputList.add(reader.nextString())
                    }
                    reader.endArray()
                    createModerationRequest = createModerationRequest.copy(
                        input = inputList
                    )
                }

                "model" -> createModerationRequest = createModerationRequest.copy(
                    textModerationModel = TextModeration.getTextModerationFromValue(reader.nextString())
                )
            }
        }
        reader.endObject()
        return createModerationRequest
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: CreateModerationRequest?) {
        writer
            .beginObject()
            .name("input")
            .beginArray()
            .also { jsonWriter -> value?.input?.forEach { jsonWriter.value(it) } }
            .endArray()
            .name("model").value(value?.textModerationModel?.value)
            .endObject()
    }
}