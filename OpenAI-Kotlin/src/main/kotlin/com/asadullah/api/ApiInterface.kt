package com.asadullah.api

import com.asadullah.api.request.CreateCompletionRequest
import com.asadullah.api.request.CreateEditRequest
import com.asadullah.api.request.CreateEmbeddingsRequest
import com.asadullah.api.request.CreateFineTuneRequest
import com.asadullah.api.request.image.*
import com.asadullah.api.request.moderation.CreateModerationRequest
import com.asadullah.api.response.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("models")
    suspend fun getModels(): Response<GetModelsResponse>

    @GET("models/{model}")
    suspend fun getModelById(@Path("model") modelId: String): Response<Model>

    @POST("completions")
    suspend fun createCompletion(@Body request: CreateCompletionRequest): Response<CreateCompletionResponse>

    @POST("edits")
    suspend fun createEdit(@Body request: CreateEditRequest): Response<CreateEditResponse>

    @POST("images/generations")
    suspend fun createImage(@Body request: CreateImageRequest): Response<ImageResponse>

    @JvmSuppressWildcards
    @Multipart
    @POST("images/edits")
    suspend fun editImage(@Part imageFile: MultipartBody.Part, @Part maskFile: MultipartBody.Part?, @PartMap request: Map<String, RequestBody>): Response<ImageResponse>

    @JvmSuppressWildcards
    @Multipart
    @POST("images/variations")
    suspend fun createImageVariation(@Part imageFile: MultipartBody.Part, @PartMap request: Map<String, RequestBody>): Response<ImageResponse>

    @POST("embeddings")
    suspend fun createEmbeddings(@Body request: CreateEmbeddingsRequest): Response<CreateEmbeddingsResponse>

    @GET("files")
    suspend fun getFiles(): Response<GetFilesResponse>

    @JvmSuppressWildcards
    @Multipart
    @POST("files")
    suspend fun uploadFile(@Part file: MultipartBody.Part, @PartMap request: Map<String, RequestBody>): Response<UploadFileResponse>

    @DELETE("files/{file_id}")
    suspend fun deleteFile(@Path("file_id") fileId: String): Response<DeleteFileResponse>

    @GET("files/{file_id}")
    suspend fun getFileById(@Path("file_id") fileId: String): Response<FileResponse>

    @GET("files/{file_id}/content")
    suspend fun getFileContentById(@Path("file_id") fileId: String): Response<FileResponse>

    @POST("fine-tunes")
    suspend fun createFineTune(@Body request: CreateFineTuneRequest): Response<FineTune>

    @GET("fine-tunes")
    suspend fun getFineTunes(): Response<GetFineTunesResponse>

    @GET("fine-tunes/{fine_tune_id}")
    suspend fun getFineTuneById(@Path("fine_tune_id") fineTuneId: String): Response<FineTune>

    @GET("fine-tunes/{fine_tune_id}/cancel")
    suspend fun cancelFineTuneById(@Path("fine_tune_id") fineTuneId: String): Response<FineTune>

    @GET("fine-tunes/{fine_tune_id}/events")
    suspend fun getEventsByFineTuneId(@Path("fine_tune_id") fineTuneId: String, @Query("stream") shouldStream: Boolean): Response<GetEventsByFineTuneIdResponse>

    @DELETE("models/{model}")
    suspend fun deleteFineTuneModel(@Path("model") modelId: String): Response<DeleteFineTuneModelResponse>

    @POST("moderations")
    suspend fun createModeration(@Body request: CreateModerationRequest): Response<CreateModerationResponse>
}