package com.ev.badchar.domain.model

sealed class Response<out T> {
    data class Success<out T>(val value: T) : Response<T>()
    data class Failure(val message: String? = null) : Response<Nothing>()
}
