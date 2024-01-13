package io.github.romantsisyk.rickandmortyapilib.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterEntity(
    val id: Int,
    val name: String,
    val status: String,
    val species: String
)