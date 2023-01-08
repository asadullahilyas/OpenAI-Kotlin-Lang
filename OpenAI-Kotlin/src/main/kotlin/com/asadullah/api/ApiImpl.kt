package com.asadullah.api

import com.asadullah.Configuration
import com.asadullah.api.request.*
import com.asadullah.api.request.image.CreateImageRequest
import com.asadullah.api.request.image.CreateImageVariationRequest
import com.asadullah.api.request.image.EditImageRequest
import com.asadullah.api.request.moderation.CreateModerationRequest
import com.asadullah.api.response.*
import com.asadullah.createApiInterface

class ApiImpl(private val configuration: Configuration) {

    private val apiInterface: ApiInterface by lazy {
        createApiInterface(configuration)
    }

    suspend fun getModels(): Response<GetModelsResponse> {
        return Response(apiInterface.getModels())
    }

    suspend fun getModelById(modelId: String): Response<Model> {
        return Response(apiInterface.getModelById(modelId))
    }

    suspend fun createCompletion(request: CreateCompletionRequest): Response<CreateCompletionResponse> {
        return Response(apiInterface.createCompletion(request))
    }

    suspend fun createEdit(request: CreateEditRequest): Response<CreateEditResponse> {
        return Response(apiInterface.createEdit(request))
    }

    suspend fun createImage(request: CreateImageRequest): Response<ImageResponse> {
        return Response(apiInterface.createImage(request))
    }

    suspend fun editImage(request: EditImageRequest): Response<ImageResponse> {
        return Response(
            apiInterface.editImage(
                imageFile = request.imageAsFormDataPart(),
                maskFile = request.maskAsFormDataPart(),
                request = request.toRequestBodyMap()
            )
        )
    }

    suspend fun createImageVariation(request: CreateImageVariationRequest): Response<ImageResponse> {
        return Response(
            apiInterface.createImageVariation(
                imageFile = request.imageAsFormDataPart(),
                request = request.toRequestBodyMap()
            )
        )
    }

    suspend fun createEmbeddings(request: CreateEmbeddingsRequest): Response<CreateEmbeddingsResponse> {
        return Response(apiInterface.createEmbeddings(request))
    }

    suspend fun getFiles(): Response<GetFilesResponse> {
        return Response(apiInterface.getFiles())
    }

    suspend fun uploadFile(request: UploadFileRequest): Response<UploadFileResponse> {
        return Response(
            apiInterface.uploadFile(
                file = request.fileAsFormDataPart(),
                request = request.toRequestBodyMap()
            )
        )
    }

    suspend fun deleteFile(fileId: String): Response<DeleteFileResponse> {
        return Response(apiInterface.deleteFile(fileId))
    }

    suspend fun getFileById(fileId: String): Response<FileResponse> {
        return Response(apiInterface.getFileById(fileId))
    }

    suspend fun getFileContentById(fileId: String): Response<FileResponse> {
        return Response(apiInterface.getFileContentById(fileId))
    }

    suspend fun createFineTune(request: CreateFineTuneRequest): Response<FineTune> {
        return Response(apiInterface.createFineTune(request))
    }

    suspend fun getFineTunes(): Response<GetFineTunesResponse> {
        return Response(apiInterface.getFineTunes())
    }

    suspend fun getFineTuneById(fineTuneId: String): Response<FineTune> {
        return Response(apiInterface.getFineTuneById(fineTuneId))
    }

    suspend fun cancelFineTuneById(fineTuneId: String): Response<FineTune> {
        return Response(apiInterface.cancelFineTuneById(fineTuneId))
    }

    suspend fun getEventsByFineTuneId(
        fineTuneId: String,
        shouldStream: Boolean
    ): Response<GetEventsByFineTuneIdResponse> {
        return Response(apiInterface.getEventsByFineTuneId(fineTuneId, shouldStream))
    }

    suspend fun deleteFineTuneModel(modelId: String): Response<DeleteFineTuneModelResponse> {
        return Response(apiInterface.deleteFineTuneModel(modelId))
    }

    suspend fun createModeration(request: CreateModerationRequest): Response<CreateModerationResponse> {
        return Response(apiInterface.createModeration(request))
    }
}