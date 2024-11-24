package com.ev.badchar.data.repository.badchar

import com.ev.badchar.data.source.remote.badchar.BadCharRemoteDataSource
import com.ev.badchar.domain.badchar.model.Character
import com.ev.badchar.domain.badchar.repository.BadCharRepository
import com.ev.badchar.domain.model.Response
import javax.inject.Inject

class BadCharRepositoryImpl @Inject constructor(private val badCharRemoteDataSource: BadCharRemoteDataSource) :
    BadCharRepository {

    override suspend fun getBadCharacters(): Response<List<Character>> =
        badCharRemoteDataSource.getBadCharacters()

}