package io.github.romantsisyk.rickandmortyapilib.data.model

import kotlinx.serialization.Serializable

@Serializable
data class EpisodesResponse(
    val results: List<EpisodeEntity>
)