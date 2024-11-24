package com.ev.badchar.data.source.remote.badchar.mappers

import com.ev.badchar.data.source.remote.badchar.model.CharacterRemote
import com.ev.badchar.domain.badchar.model.Character

internal fun List<CharacterRemote>.toDomain(): List<Character> = this.map { it.toDomain() }

private fun CharacterRemote.toDomain(): Character {
    return Character(
        this.appearance,
        this.betterCallSaulAppearance,
        this.birthday,
        this.category,
        this.charId,
        this.img,
        this.name,
        this.nickname,
        this.occupation,
        this.portrayed,
        this.status
    )
}


