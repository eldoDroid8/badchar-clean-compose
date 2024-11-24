package com.ev.badchar.data.source.remote.badchar.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterRemote(
    @Json(name = "appearance")
    val appearance: List<Int>? = null,
    @Json(name = "better_call_saul_appearance")
    val betterCallSaulAppearance: List<Int>? = null,
    @Json(name = "birthday")
    val birthday: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "char_id")
    val charId: Int,
    @Json(name = "img")
    val img: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "nickname")
    val nickname: String,
    @Json(name = "occupation")
    val occupation: List<String>? = null,
    @Json(name = "portrayed")
    val portrayed: String,
    @Json(name = "status")
    val status: String
)
