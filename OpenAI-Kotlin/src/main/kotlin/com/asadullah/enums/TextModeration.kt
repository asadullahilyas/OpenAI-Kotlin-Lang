package com.asadullah.enums

enum class TextModeration(val value: String) {

    Stable("text-moderation-stable"),
    Latest("text-moderation-latest");

    companion object {
        fun getTextModerationFromValue(value: String): TextModeration {
            return when (value) {
                "text-moderation-stable" -> Stable
                "text-moderation-latest" -> Latest
                else -> throw IllegalArgumentException("$value is not applicable")
            }
        }
    }
}