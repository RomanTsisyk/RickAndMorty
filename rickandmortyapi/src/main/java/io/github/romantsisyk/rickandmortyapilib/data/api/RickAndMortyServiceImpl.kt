package io.github.romantsisyk.rickandmortyapilib.data.api

import io.github.romantsisyk.rickandmortyapilib.data.model.CharactersResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.EpisodesResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.LocationsResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*

/**
 * Implementation of [RickAndMortyService] for interacting with the Rick and Morty API.
 *
 * @property client The [HttpClient] used to make network requests.
 */
class RickAndMortyServiceImpl(private val client: HttpClient) : RickAndMortyService {

    private companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api"
    }

    /**
     * Fetches character data from the Rick and Morty API.
     *
     * @return [CharactersResponse] containing character details.
     */
    override suspend fun getCharacters(): CharactersResponse {
        return getApiResponse("character")
    }

    /**
     * Fetches episode data from the Rick and Morty API.
     *
     * @return [EpisodesResponse] containing episode details.
     */
    override suspend fun getEpisodes(): EpisodesResponse {
        return getApiResponse("episode")
    }

    /**
     * Fetches location data from the Rick and Morty API.
     *
     * @return [LocationsResponse] containing location details.
     */
    override suspend fun getLocations(): LocationsResponse {
        return getApiResponse("location")
    }

    /**
     * Generic function to fetch data from a given API endpoint.
     *
     * @param T The type of response expected.
     * @param endpoint The endpoint path to append to the base URL.
     * @return The response of type [T] from the API.
     */
    private suspend inline fun <reified T> getApiResponse(endpoint: String): T {
        return client.get("$BASE_URL/$endpoint").body()
    }
}