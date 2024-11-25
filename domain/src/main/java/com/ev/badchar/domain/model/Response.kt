package com.ev.badchar.domain.model

sealed class Response<out T> {
    data class Success<out T>(val value: T) : Response<T>()
    data class Failure(val message: String? = null) : Response<Nothing>()
}

inline fun <T> Response<T>.onSuccess(function: (Response.Success<T>) -> Unit): Response<T> =
    when (this) {
        is Response.Success -> {
            function(this)
            this
        }

        is Response.Failure -> this
    }

inline fun <T> Response<T>.onFailure(function: (Response.Failure) -> Unit): Response<T> = when (this) {
    is Response.Success -> this

    is Response.Failure -> {
        function(this)
        this
    }
}