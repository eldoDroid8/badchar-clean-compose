package com.ev.badchar.data.source.remote.base

import com.ev.badchar.data.source.remote.model.GeneralErrorRemote
import com.ev.badchar.data.source.remote.model.Result
import com.squareup.moshi.JsonAdapter
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.net.SocketException

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
abstract class BaseRemoteDataSource constructor(
    val retrofit: Retrofit, private val moshiErrorAdapter:
    JsonAdapter<GeneralErrorRemote>
) {
    suspend fun <T : Any> getResponse(
        request: suspend () -> Response<T>
    ): Result<T> {
        return try {
            val result = request.invoke()
            return if (result.isSuccessful) {
                if (null == result.body()) {
                    Result.Failure(GeneralErrorRemote(statusMessage = "Empty response"))
                } else {
                    Result.Success(
                        result.body() ?: return Result.Failure(
                            GeneralErrorRemote()
                        )
                    )
                }
            } else {
                val errorResponse: GeneralErrorRemote = parseError(result)
                Result.Failure(errorResponse)
            }
        } catch (e: IOException) {
            Result.Failure(GeneralErrorRemote(statusMessage = "Unknown error"))
        } catch (e: SocketException) {
            Result.Failure(GeneralErrorRemote(statusMessage = "Please check your network connection"))
        } catch (e: HttpException) {
            val errorResponse = convertErrorBody(e)
            Result.Failure(errorResponse)
        }
    }

    private fun parseError(response: Response<*>): GeneralErrorRemote {
        val converter = retrofit.responseBodyConverter<GeneralErrorRemote>(
            GeneralErrorRemote::class.java, arrayOfNulls
                (0)
        )
        return try {
            val error = converter.convert(response.errorBody()) ?: GeneralErrorRemote(
                statusMessage = "Unknown error"
            )
            error

        } catch (e: IOException) {
            GeneralErrorRemote()
        }
    }

    private fun convertErrorBody(throwable: HttpException): GeneralErrorRemote {
        return try {
            val response = moshiErrorAdapter.fromJson(throwable.response()?.errorBody()?.source())
            response ?: GeneralErrorRemote(statusMessage = "Unknown Error")
        } catch (exception: Exception) {
            val error = GeneralErrorRemote(statusMessage = "Unknown error")
            error
        }
    }
}