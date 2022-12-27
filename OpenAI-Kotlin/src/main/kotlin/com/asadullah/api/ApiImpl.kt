package com.asadullah.api

import com.asadullah.api.request.*
import com.asadullah.api.request.image.CreateImageRequest
import com.asadullah.api.request.image.CreateImageVariationRequest
import com.asadullah.api.request.image.EditImageRequest
import com.asadullah.api.request.moderation.CreateModerationRequest
import com.asadullah.api.response.*
import com.asadullah.createApiInterface

class ApiImpl(private val secret: String) {

    private val apiInterface: ApiInterface by lazy {
        createApiInterface(secret)
    }

    suspend fun getModels(): GetModelsResponse {
        return apiInterface.getModels()
    }

    suspend fun getModelById(modelId: String): Model {
        return apiInterface.getModelById(modelId)
    }

    suspend fun createCompletion(request: CreateCompletionRequest): CreateCompletionResponse {
        return apiInterface.createCompletion(request)
    }

    suspend fun createEdit(request: CreateEditRequest): CreateEditResponse {
        return apiInterface.createEdit(request)
    }

    suspend fun createImage(request: CreateImageRequest): ImageResponse {
        return apiInterface.createImage(request)
    }

    suspend fun editImage(request: EditImageRequest): ImageResponse {
        return apiInterface.editImage(request.toRequestBodyMap())
    }

    suspend fun createImageVariation(request: CreateImageVariationRequest): ImageResponse {
        return apiInterface.createImageVariation(request)
    }

    suspend fun createEmbeddings(request: CreateEmbeddingsRequest): CreateEmbeddingsResponse {
        return apiInterface.createEmbeddings(request)
    }

    suspend fun getFiles(): GetFilesResponse {
        return apiInterface.getFiles()
    }

    suspend fun uploadFile(request: UploadFileRequest): UploadFileResponse {
        return apiInterface.uploadFile(request.toRequestBodyMap())
    }

    suspend fun deleteFile(fileId: String): DeleteFileResponse {
        return apiInterface.deleteFile(fileId)
    }

    suspend fun getFileById(fileId: String): FileResponse {
        return apiInterface.getFileById(fileId)
    }

    suspend fun getFileContentById(fileId: String): FileResponse {
        return apiInterface.getFileContentById(fileId)
    }

    suspend fun createFineTune(request: CreateFineTuneRequest): FineTune {
        return apiInterface.createFineTune(request)
    }

    suspend fun getFineTunes(): GetFineTunesResponse {
        return apiInterface.getFineTunes()
    }

    suspend fun getFineTuneById(fineTuneId: String): FineTune {
        return apiInterface.getFineTuneById(fineTuneId)
    }

    suspend fun cancelFineTuneById(fineTuneId: String): FineTune {
        return apiInterface.cancelFineTuneById(fineTuneId)
    }

    suspend fun getEventsByFineTuneId(fineTuneId: String, shouldStream: Boolean): GetEventsByFineTuneIdResponse {
        return apiInterface.getEventsByFineTuneId(fineTuneId, shouldStream)
    }

    suspend fun deleteFineTuneModel(modelId: String): DeleteFineTuneModelResponse {
        return apiInterface.deleteFineTuneModel(modelId)
    }

    suspend fun createModeration(request: CreateModerationRequest): CreateModerationResponse {
        return apiInterface.createModeration(request)
    }
}