package com.ev.badchar.data.source.remote.badchar.service

import com.ev.badchar.data.source.remote.badchar.model.CharacterRemote
import retrofit2.Response
import retrofit2.http.GET

interface BadCharacterRetrofitService {
    @GET("/characters")
    suspend fun getAllBadCharacters(): Response<List<CharacterRemote>>
}