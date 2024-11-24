package com.ev.badchar.data.source.remote.extension

import com.ev.badchar.data.source.remote.model.Result
import com.ev.badchar.domain.model.Response

fun<T> Result<T>.toResponse(): Response<T> = when(this) {
    is Result.Success -> Response.Success(this.data)
    is Result.Failure -> Response.Failure(this.error.statusMessage)
}