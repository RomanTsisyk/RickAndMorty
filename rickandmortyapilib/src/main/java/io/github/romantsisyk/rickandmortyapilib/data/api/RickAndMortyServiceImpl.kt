package io.github.romantsisyk.rickandmortyapilib.data.api

import io.github.romantsisyk.rickandmortyapilib.data.model.CharactersResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.EpisodesResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.LocationsResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*

class RickAndMortyServiceImpl(private val client: HttpClient) : RickAndMortyService {

    override suspend fun getCharacters(): CharactersResponse {
        return client.get("https://rickandmortyapi.com/api/character").body()
    }

    override suspend fun getEpisodes(): EpisodesResponse {
        return client.get("https://rickandmortyapi.com/api/episode").body()
    }

    override suspend fun getLocations(): LocationsResponse {
        return client.get("https://rickandmortyapi.com/api/location").body()
    }
}