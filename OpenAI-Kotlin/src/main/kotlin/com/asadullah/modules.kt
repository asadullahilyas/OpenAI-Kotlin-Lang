package com.asadullah

import com.asadullah.api.ApiInterface
import com.asadullah.api.request.image.jsonadapter.CreateImageVariationRequestJsonAdapter
import com.asadullah.api.request.image.jsonadapter.CreateImageRequestJsonAdapter
import com.asadullah.api.request.image.jsonadapter.EditImageRequestJsonAdapter
import com.asadullah.api.request.moderation.CreateModerationRequestJsonAdapter
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun createMoshi(): Moshi {
    return Moshi
        .Builder()
        .add(CreateImageRequestJsonAdapter())
        .add(EditImageRequestJsonAdapter())
        .add(CreateImageVariationRequestJsonAdapter())
        .add(CreateModerationRequestJsonAdapter())
        .build()
}

fun createOkHttpClient(secret: String): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .addInterceptor(createAuthInterceptor(secret))
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()
}

fun createAuthInterceptor(secret: String): Interceptor {

    val secretKey = secret

    return Interceptor {chain ->
        chain.request().newBuilder()
            .addHeader("User-Agent", "OpenAI-Kotlin")
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer $secretKey")
            .build()
            .let { chain.proceed(it) }
    }
}

fun createApiInterface(secret: String): ApiInterface {
    return Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(createMoshi())
        )
        .client(createOkHttpClient(secret))
        .build()
        .create(ApiInterface::class.java)
}