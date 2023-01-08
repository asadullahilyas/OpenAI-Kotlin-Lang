package com.asadullah

import com.asadullah.api.ApiImpl
import com.asadullah.api.request.*
import com.asadullah.api.request.image.*
import com.asadullah.api.request.moderation.CreateModerationRequest
import com.asadullah.api.response.*

class OpenAI(private val configuration: Configuration) {

    private val api: ApiImpl by lazy {
        ApiImpl(configuration)
    }

    /**
     * Lists the currently available models, and provides basic information
     * about each one such as the owner and availability.
     */
    suspend fun getModels(): Response<GetModelsResponse> {
        return api.getModels()
    }

    /**
     * Retrieves a model instance, providing basic information about the
     * model such as the owner and permissioning.
     */
    suspend fun getModelById(modelId: String): Response<Model> {
        return api.getModelById(modelId)
    }

    /**
     * Creates a completion for the provided prompt and parameters.
     */
    suspend fun createCompletion(request: CreateCompletionRequest): Response<CreateCompletionResponse> {
        return api.createCompletion(request)
    }

    /**
     * Creates a new edit for the provided input, instruction, and parameters.
     */
    suspend fun createEdit(request: CreateEditRequest): Response<CreateEditResponse> {
        return api.createEdit(request)
    }

    /**
     * Creates an image given a prompt.
     */
    suspend fun createImage(request: CreateImageRequest): Response<ImageResponse> {
        return api.createImage(request)
    }

    /**
     * Creates an edited or extended image given an original image and
     * a prompt.
     */
    suspend fun editImage(request: EditImageRequest): Response<ImageResponse> {
        return api.editImage(request)
    }

    /**
     * Creates a variation of a given image.
     */
    suspend fun createImageVariation(request: CreateImageVariationRequest): Response<ImageResponse> {
        return api.createImageVariation(request)
    }

    /**
     * Creates an embedding vector representing the input text.
     */
    suspend fun createEmbeddings(request: CreateEmbeddingsRequest): Response<CreateEmbeddingsResponse> {
        return api.createEmbeddings(request)
    }

    /**
     * Returns a list of files that belong to the user's organization.
     */
    suspend fun getFiles(): Response<GetFilesResponse> {
        return api.getFiles()
    }

    /**
     * Upload a file that contains document(s) to be used across various
     * endpoints/features. Currently, the size of all the files uploaded
     * by one organization can be up to 1 GB. Please contact OpenAI if you
     * need to increase the storage limit.
     */
    suspend fun uploadFile(request: UploadFileRequest): Response<UploadFileResponse> {
        return api.uploadFile(request)
    }

    /**
     * Delete a file.
     */
    suspend fun deleteFile(fileId: String): Response<DeleteFileResponse> {
        return api.deleteFile(fileId)
    }

    /**
     * Returns information about a specific file.
     */
    suspend fun getFileById(fileId: String): Response<FileResponse> {
        return api.getFileById(fileId)
    }

    /**
     * Returns the contents of the specified file
     */
    suspend fun getFileContentById(fileId: String): Response<FileResponse> {
        return api.getFileContentById(fileId)
    }

    /**
     * Creates a job that fine-tunes a specified model from a given dataset.
     *
     * Response includes details of the enqueued job including job status
     * and the name of the fine-tuned models once complete.
     */
    suspend fun createFineTune(request: CreateFineTuneRequest): Response<FineTune> {
        return api.createFineTune(request)
    }

    /**
     * List your organization's fine-tuning jobs.
     */
    suspend fun getFineTunes(): Response<GetFineTunesResponse> {
        return api.getFineTunes()
    }

    /**
     * Gets info about the fine-tune job.
     */
    suspend fun getFineTuneById(fineTuneId: String): Response<FineTune> {
        return api.getFineTuneById(fineTuneId)
    }

    /**
     * Immediately cancel a fine-tune job.
     */
    suspend fun cancelFineTuneById(fineTuneId: String): Response<FineTune> {
        return api.cancelFineTuneById(fineTuneId)
    }

    /**
     * Get fine-grained status updates for a fine-tune job.
     *
     * Whether to stream events for the fine-tune job. If set to true,
     * events will be sent as data-only server-sent events as they become
     * available. The stream will terminate with a data: [DONE] message
     * when the job is finished (succeeded, cancelled, or failed).
     *
     * If set to false, only events generated so far will be returned.
     */
    suspend fun getEventsByFineTuneId(fineTuneId: String, shouldStream: Boolean = false): Response<GetEventsByFineTuneIdResponse> {
        return api.getEventsByFineTuneId(fineTuneId, shouldStream)
    }

    /**
     * Delete a fine-tuned model. You must have the Owner role in your
     * organization.
     */
    suspend fun deleteFineTuneModel(modelId: String): Response<DeleteFineTuneModelResponse> {
        return api.deleteFineTuneModel(modelId)
    }

    /**
     * Classifies if text violates OpenAI's Content Policy
     */
    suspend fun createModeration(request: CreateModerationRequest): Response<CreateModerationResponse> {
        return api.createModeration(request)
    }
}