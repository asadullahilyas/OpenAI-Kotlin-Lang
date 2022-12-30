package com.asadullah

data class Configuration(
    val secretKey: String,
    val connectTimeoutInSeconds: Long = 13,
    val readTimeoutInSeconds: Long = 13,
    val writeTimeoutInSeconds: Long = 13,
    val enableOkHttpLogging: Boolean = false
)