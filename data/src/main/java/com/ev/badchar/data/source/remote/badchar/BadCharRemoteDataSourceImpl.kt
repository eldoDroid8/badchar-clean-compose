package com.ev.badchar.data.source.remote.badchar

import com.ev.badchar.data.source.remote.badchar.mappers.toDomain
import com.ev.badchar.data.source.remote.badchar.service.BadCharacterRetrofitService
import com.ev.badchar.data.source.remote.base.BaseRemoteDataSource
import com.ev.badchar.data.source.remote.extension.toResponse
import com.ev.badchar.data.source.remote.model.GeneralErrorRemote
import com.ev.badchar.data.source.remote.model.mapSuccess
import com.ev.badchar.domain.badchar.model.Character
import com.ev.badchar.domain.model.Response
import com.squareup.moshi.JsonAdapter
import retrofit2.Retrofit
import javax.inject.Inject


class BadCharRemoteDataSourceImpl @Inject constructor(
    private val badCharacterRetrofitService: BadCharacterRetrofitService,
    retrofitClient: Retrofit, moshiAdapter: JsonAdapter<GeneralErrorRemote>
) : BaseRemoteDataSource(retrofitClient, moshiAdapter), BadCharRemoteDataSource {
    override suspend fun getBadCharacters(): Response<List<Character>> =
        getResponse(request = { badCharacterRetrofitService.getAllBadCharacters() }).mapSuccess {
            it.toDomain()
        }.toResponse()
}