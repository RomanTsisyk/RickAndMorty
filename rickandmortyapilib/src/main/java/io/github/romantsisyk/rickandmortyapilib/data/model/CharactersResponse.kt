package io.github.romantsisyk.rickandmortyapilib.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    val results: List<CharacterEntity>
)