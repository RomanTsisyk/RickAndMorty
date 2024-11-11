package io.github.romantsisyk.rickandmortyrepositoryib.repository

import io.github.romantsisyk.rickandmortyrepositoryib.model.Character
import io.github.romantsisyk.rickandmortyrepositoryib.model.Episode
import io.github.romantsisyk.rickandmortyrepositoryib.model.Location
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface defining data access methods for the Rick and Morty API.
 * This interface allows interaction with character, episode, and location data.
 */
interface RickAndMortyRepository {

    /**
     * Retrieves a list of characters from the repository.
     *
     * @return A list of [Character] objects.
     */
    suspend fun getCharacters(): List<Character>

    /**
     * Retrieves a list of episodes from the repository.
     *
     * @return A list of [Episode] objects.
     */
    suspend fun getEpisodes(): List<Episode>

    /**
     * Retrieves a list of locations from the repository.
     *
     * @return A list of [Location] objects.
     */
    suspend fun getLocations(): List<Location>
}
