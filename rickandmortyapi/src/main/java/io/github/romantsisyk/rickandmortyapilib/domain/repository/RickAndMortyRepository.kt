package io.github.romantsisyk.rickandmortyapilib.domain.repository

import io.github.romantsisyk.rickandmortyapilib.domain.model.Episode
import io.github.romantsisyk.rickandmortyapilib.domain.model.Location
import io.github.romantsisyk.rickandmortyapilib.domain.model.Character

/**
 * RickAndMortyRepository defines the contract for accessing character, episode,
 * and location data in the application.
 */
interface RickAndMortyRepository {

    /**
     * Retrieves a list of characters.
     *
     * @return List of [Character] representing character details.
     */
    suspend fun getCharacters(): List<Character>

    /**
     * Retrieves a list of episodes.
     *
     * @return List of [Episode] representing episode details.
     */
    suspend fun getEpisodes(): List<Episode>

    /**
     * Retrieves a list of locations.
     *
     * @return List of [Location] representing location details.
     */
    suspend fun getLocations(): List<Location>
}
