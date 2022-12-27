package com.asadullah.api

import com.asadullah.api.request.CreateCompletionRequest
import com.asadullah.api.request.CreateEditRequest
import com.asadullah.api.request.CreateEmbeddingsRequest
import com.asadullah.api.request.CreateFineTuneRequest
import com.asadullah.api.request.image.*
import com.asadullah.api.request.moderation.CreateModerationRequest
import com.asadullah.api.response.*
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("models")
    suspend fun getModels(): GetModelsResponse

    @GET("models/{model}")
    suspend fun getModelById(@Path("model") modelId: String): Model

    @POST("completions")
    suspend fun createCompletion(@Body request: CreateCompletionRequest): CreateCompletionResponse

    @POST("edits")
    suspend fun createEdit(@Body request: CreateEditRequest): CreateEditResponse

    @POST("images/generations")
    suspend fun createImage(@Body request: CreateImageRequest): ImageResponse

    @Multipart
    @POST("images/edits")
    suspend fun editImage(@PartMap request: Map<String, RequestBody>): ImageResponse

    @POST("images/variations")
    suspend fun createImageVariation(@Body request: CreateImageVariationRequest): ImageResponse

    @POST("embeddings")
    suspend fun createEmbeddings(@Body request: CreateEmbeddingsRequest): CreateEmbeddingsResponse

    @GET("files")
    suspend fun getFiles(): GetFilesResponse

    @Multipart
    @POST("files")
    suspend fun uploadFile(@PartMap request: Map<String, RequestBody>): UploadFileResponse

    @DELETE("files/{file_id}")
    suspend fun deleteFile(@Path("file_id") fileId: String): DeleteFileResponse

    @GET("files/{file_id}")
    suspend fun getFileById(@Path("file_id") fileId: String): FileResponse

    @GET("files/{file_id}/content")
    suspend fun getFileContentById(@Path("file_id") fileId: String): FileResponse

    @POST("fine-tunes")
    suspend fun createFineTune(@Body request: CreateFineTuneRequest): FineTune

    @GET("fine-tunes")
    suspend fun getFineTunes(): GetFineTunesResponse

    @GET("fine-tunes/{fine_tune_id}")
    suspend fun getFineTuneById(@Path("fine_tune_id") fineTuneId: String): FineTune

    @GET("fine-tunes/{fine_tune_id}/cancel")
    suspend fun cancelFineTuneById(@Path("fine_tune_id") fineTuneId: String): FineTune

    @GET("fine-tunes/{fine_tune_id}/events")
    suspend fun getEventsByFineTuneId(@Path("fine_tune_id") fineTuneId: String, @Query("stream") shouldStream: Boolean): GetEventsByFineTuneIdResponse

    @DELETE("models/{model}")
    suspend fun deleteFineTuneModel(@Path("model") modelId: String): DeleteFineTuneModelResponse

    @POST("moderations")
    suspend fun createModeration(@Body request: CreateModerationRequest): CreateModerationResponse
}