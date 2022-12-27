package com.asadullah.api.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateFineTuneRequest(

    /**
     * The ID of an uploaded file that contains training data.
     *
     * Your dataset must be formatted as a JSONL file, where each
     * training example is a JSON object with the keys "prompt" and
     * "completion". Additionally, you must upload your file with
     * the purpose fine-tune.
     */
    @Json(name = "training_file")
    val trainingFileId: String,

    /**
     * The ID of an uploaded file that contains validation data.
     *
     * If you provide this file, the data is used to generate validation
     * metrics periodically during fine-tuning. These metrics can be viewed
     * in the fine-tuning results file. Your train and validation data
     * should be mutually exclusive.
     *
     * Your dataset must be formatted as a JSONL file, where each validation
     * example is a JSON object with the keys "prompt" and "completion".
     * Additionally, you must upload your file with the purpose fine-tune.
     */
    @Json(name = "validation_file")
    val validationFileId: String? = null,

    /**
     * The name of the base model to fine-tune. You can select one of "ada",
     * "babbage", "curie", "davinci", or a fine-tuned model created after
     * 2022-04-21.
     */
    @Json(name = "model")
    val model: String? = null,

    /**
     * The number of epochs to train the model for. An epoch refers to
     * one full cycle through the training dataset.
     */
    @Json(name = "n_epochs")
    val numberOfEpochs: Int? = null,

    /**
     * The batch size to use for training. The batch size is the number
     * of training examples used to train a single forward and backward pass.
     *
     * By default, the batch size will be dynamically configured to be ~0.2%
     * of the number of examples in the training set, capped at 256 - in general,
     * we've found that larger batch sizes tend to work better for larger datasets.
     */
    @Json(name = "batch_size")
    val batchSize: Int? = null,

    /**
     * The learning rate multiplier to use for training. The fine-tuning
     * learning rate is the original learning rate used for pretraining
     * multiplied by this value.
     *
     * By default, the learning rate multiplier is the 0.05, 0.1, or 0.2
     * depending on final batchSize (larger learning rates tend to perform
     * better with larger batch sizes). OpenAI recommends experimenting with
     * values in the range 0.02 to 0.2 to see what produces the best results.
     */
    @Json(name = "learning_rate_multiplier")
    val learningRateMultiplier: Float? = null,

    /**
     * The weight to use for loss on the prompt tokens. This controls how much
     * the model tries to learn to generate the prompt (as compared to the
     * completion which always has a weight of 1.0), and can add a stabilizing
     * effect to training when completions are short.
     *
     * If prompts are extremely long (relative to completions), it may make
     * sense to reduce this weight to avoid over-prioritizing learning
     * the prompt.
     */
    @Json(name = "prompt_loss_weight")
    val promptLossWeight: Float? = null,

    /**
     * If set, OpenAI calculates classification-specific metrics such as accuracy
     * and F-1 score using the validation set at the end of every epoch. These
     * metrics can be viewed in the results file.
     *
     * In order to compute classification metrics, you must provide a validationFile.
     * Additionally, you must specify numberOfClassesInClassificationTask for multiclass
     * classification or positiveClassInBinaryClassification for binary classification.
     */
    @Json(name = "compute_classification_metrics")
    val computeClassificationMetrics: Boolean = false,

    /**
     * The number of classes in a classification task.
     *
     * This parameter is required for multiclass classification.
     */
    @Json(name = "classification_n_classes")
    val numberOfClassesInClassificationTask: Int? = null,

    /**
     * The positive class in binary classification.
     *
     * This parameter is needed to generate precision, recall, and F1 metrics
     * when doing binary classification.
     */
    @Json(name = "classification_positive_class")
    val positiveClassInBinaryClassification: String? = null,

    /**
     * If this is provided, OpenAI calculates F-beta scores at the specified
     * beta values. The F-beta score is a generalization of F-1 score. This is
     * only used for binary classification.
     *
     * With a beta of 1 (i.e. the F-1 score), precision and recall are given
     * the same weight. A larger beta score puts more weight on recall and
     * less on precision. A smaller beta score puts more weight on precision
     * and less on recall.
     */
    @Json(name = "classification_betas")
    val classificationBetas: List<Int>? = null,

    /**
     * A string of up to 40 characters that will be added to your fine-tuned
     * model name.
     *
     * For example, a suffix of "custom-model-name" would produce a model name
     * like ada:ft-your-org:custom-model-name-2022-02-15-04-21-04.
     */
    @Json(name = "suffix")
    val suffix: String? = null
)
