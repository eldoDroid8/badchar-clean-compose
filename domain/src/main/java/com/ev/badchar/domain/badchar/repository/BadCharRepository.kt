package com.ev.badchar.domain.badchar.repository

import com.ev.badchar.domain.badchar.model.Character
import com.ev.badchar.domain.model.Response

interface BadCharRepository {
    suspend fun getBadCharacters(): Response<List<Character>>
}