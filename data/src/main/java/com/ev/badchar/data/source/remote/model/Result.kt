package com.ev.badchar.data.source.remote.model


sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val error: GeneralErrorRemote) : Result<Nothing>()
}

internal inline fun <R, T> Result<T>.mapSuccess(
    transform: (value: T) -> R
): Result<R> =
    when (this) {
        is Result.Success -> {
            try {
                Result.Success(transform(data))
            } catch (e: Exception) {
                Result.Failure(GeneralErrorRemote())
            }
        }

        is Result.Failure -> this

    }

