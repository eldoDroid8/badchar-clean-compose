package com.ev.badchar.data.source.remote.badchar

import com.ev.badchar.domain.badchar.model.Character
import com.ev.badchar.domain.model.Response

interface BadCharRemoteDataSource {

    suspend fun getBadCharacters(): Response<List<Character>>
}