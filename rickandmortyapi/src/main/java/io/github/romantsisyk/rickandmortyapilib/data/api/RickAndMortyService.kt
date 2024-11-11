package io.github.romantsisyk.rickandmortyapilib.data.api

import io.github.romantsisyk.rickandmortyapilib.data.model.CharactersResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.EpisodesResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.LocationsResponse

/**
 * RickAndMortyService is an interface defining the API endpoints for accessing
 * character, episode, and location information from the Rick and Morty API.
 */
interface RickAndMortyService {

    /**
     * Fetches a list of characters from the Rick and Morty API.
     *
     * @return CharactersResponse containing details of all available characters.
     * @throws IOException if a network error occurs.
     * @throws HttpException if the server returns a non-2xx response.
     */
    suspend fun getCharacters(): CharactersResponse

    /**
     * Fetches a list of episodes from the Rick and Morty API.
     *
     * @return EpisodesResponse containing details of all available episodes.
     * @throws IOException if a network error occurs.
     * @throws HttpException if the server returns a non-2xx response.
     */
    suspend fun getEpisodes(): EpisodesResponse

    /**
     * Fetches a list of locations from the Rick and Morty API.
     *
     * @return LocationsResponse containing details of all available locations.
     * @throws IOException if a network error occurs.
     * @throws HttpException if the server returns a non-2xx response.
     */
    suspend fun getLocations(): LocationsResponse
}
