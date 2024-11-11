package io.github.romantsisyk.rickandmortyapilib.data.repository

import io.github.romantsisyk.rickandmortyapilib.domain.model.Character
import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyapilib.data.api.RickAndMortyService
import io.github.romantsisyk.rickandmortyapilib.domain.model.Episode
import io.github.romantsisyk.rickandmortyapilib.domain.model.Location

/**
 * Implementation of [RickAndMortyRepository] to handle data fetching and mapping
 * from API responses to domain models.
 *
 * @property service The [RickAndMortyService] to retrieve data from the Rick and Morty API.
 */
class RickAndMortyRepositoryImpl(
    private val service: RickAndMortyService
) : RickAndMortyRepository {

    /**
     * Retrieves a list of characters from the API and maps them to domain models.
     *
     * @return List of [Character] containing character details.
     */
    override suspend fun getCharacters(): List<Character> {
        val response = service.getCharacters()
        return response.results.map { entity ->
            Character(id = entity.id, name = entity.name, status = entity.status)
        }
    }

    /**
     * Retrieves a list of episodes from the API and maps them to domain models.
     *
     * @return List of [Episode] containing episode details.
     */
    override suspend fun getEpisodes(): List<Episode> {
        val response = service.getEpisodes()
        return response.results.map { entity ->
            Episode(id = entity.id, name = entity.name, episodeCode = entity.episode)
        }
    }

    /**
     * Retrieves a list of locations from the API and maps them to domain models.
     *
     * @return List of [Location] containing location details.
     */
    override suspend fun getLocations(): List<Location> {
        val response = service.getLocations()
        return response.results.map { entity ->
            Location(id = entity.id, name = entity.name, type = entity.type)
        }
    }
}
