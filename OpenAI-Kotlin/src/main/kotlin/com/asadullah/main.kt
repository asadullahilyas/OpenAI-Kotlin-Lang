package com.asadullah

import kotlinx.coroutines.runBlocking
import java.io.File

fun main() {

    val openAI = OpenAI("YOUR_SECRET_KEY_HERE")

    runBlocking {
        openAI.getModels()
    }
}