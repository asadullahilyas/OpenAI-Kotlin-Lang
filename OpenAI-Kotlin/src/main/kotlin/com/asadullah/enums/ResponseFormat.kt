package com.asadullah.enums

enum class ResponseFormat(val format: String) {

    URL("url"),
    Base64("b64_json");

    companion object {
        fun getResponseFormatFromStringFormat(stringFormat: String): ResponseFormat {
            return when (stringFormat) {
                "url" -> URL
                "b64_json" -> Base64
                else -> throw IllegalArgumentException("$stringFormat is not applicable")
            }
        }
    }
}