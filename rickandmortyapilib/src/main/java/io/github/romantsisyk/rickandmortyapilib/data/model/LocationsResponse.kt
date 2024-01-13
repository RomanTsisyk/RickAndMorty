package io.github.romantsisyk.rickandmortyapilib.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationsResponse(
    val results: List<LocationEntity>
)