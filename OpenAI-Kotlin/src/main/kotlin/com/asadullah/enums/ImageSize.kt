package com.asadullah.enums

enum class ImageSize(val size: String) {

    /**
     * Small image resolution is 256x256
     */
    Small("256x256"),

    /**
     * Medium image resolution is 512x512
     */
    Medium("512x512"),

    /**
     * Large image resolution is 1024x1024
     */
    Large("1024x1024");

    companion object {
        fun getImageSizeFromStringSize(stringSize: String): ImageSize {
            return when (stringSize) {
                "256x256" -> Small
                "512x512" -> Medium
                "1024x1024" -> Large
                else -> throw IllegalArgumentException("$stringSize is not applicable")
            }
        }
    }
}