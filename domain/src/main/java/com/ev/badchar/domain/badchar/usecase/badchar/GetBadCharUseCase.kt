package com.ev.badchar.domain.badchar.usecase.badchar

import com.ev.badchar.domain.badchar.repository.BadCharRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBadCharUseCase @Inject constructor(private val badCharRepository: BadCharRepository) {

    suspend fun invoke() = withContext(Dispatchers.IO) {
        badCharRepository.getBadCharacters()
    }
}