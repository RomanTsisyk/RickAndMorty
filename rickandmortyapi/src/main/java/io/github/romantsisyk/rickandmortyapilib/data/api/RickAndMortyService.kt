package io.github.romantsisyk.rickandmortyapilib.data.api

import io.github.romantsisyk.rickandmortyapilib.data.model.CharactersResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.EpisodesResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.LocationsResponse


interface RickAndMortyService {
    suspend fun getCharacters(): CharactersResponse
    suspend fun getEpisodes(): EpisodesResponse
    suspend fun getLocations(): LocationsResponse
}