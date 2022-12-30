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

fun createOkHttpClient(configuration: Configuration): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = if (configuration.enableOkHttpLogging)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            }
        )
        .addInterceptor(createAuthInterceptor(configuration.secretKey))
        .connectTimeout(configuration.connectTimeoutInSeconds, TimeUnit.SECONDS)
        .readTimeout(configuration.readTimeoutInSeconds, TimeUnit.SECONDS)
        .writeTimeout(configuration.writeTimeoutInSeconds, TimeUnit.SECONDS)
        .build()
}

fun createAuthInterceptor(secretKey: String): Interceptor {

    return Interceptor {chain ->
        chain.request().newBuilder()
            .addHeader("User-Agent", "OpenAI-Kotlin")
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer $secretKey")
            .build()
            .let { chain.proceed(it) }
    }
}

fun createApiInterface(configuration: Configuration): ApiInterface {
    return Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(createMoshi())
        )
        .client(createOkHttpClient(configuration))
        .build()
        .create(ApiInterface::class.java)
}