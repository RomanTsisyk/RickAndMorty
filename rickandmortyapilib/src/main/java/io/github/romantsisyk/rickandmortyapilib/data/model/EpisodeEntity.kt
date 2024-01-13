package io.github.romantsisyk.rickandmortyapilib.data.model

import kotlinx.serialization.Serializable

@Serializable
data class EpisodeEntity(
    val id: Int,
    val name: String,
    val episode: String
)