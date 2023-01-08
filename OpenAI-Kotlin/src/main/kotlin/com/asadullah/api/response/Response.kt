package com.asadullah.api.response

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import java.nio.charset.Charset

@OptIn(ExperimentalStdlibApi::class)
class Response<T : Any>(
    private val response: retrofit2.Response<T>
) {

    val data: T? by lazy {
        response.body()
    }

    val error: ErrorResponse? by lazy {
        try {
            val strResponse = response.errorBody()?.byteString()?.string(Charset.defaultCharset()) ?: return@lazy null
            Moshi.Builder().build().adapter<ErrorResponse>().fromJson(strResponse)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun isSuccessful() = response.isSuccessful
}