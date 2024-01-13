package io.github.romantsisyk.rickandmortyapilib.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationEntity(
    val id: Int,
    val name: String,
    val type: String
)