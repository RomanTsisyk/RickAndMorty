package io.github.romantsisyk.rickandmortyapilib.domain.usecase

import io.github.romantsisyk.rickandmortyapilib.domain.model.Location
import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository

/**
 * Use case for retrieving a list of locations from the repository.
 *
 * @property repository The [RickAndMortyRepository] used to fetch location data.
 */
class GetLocationsUseCase(private val repository: RickAndMortyRepository) {

    /**
     * Invokes the use case to get a list of locations.
     *
     * @return List of [Location] containing location details.
     */
    suspend operator fun invoke(): List<Location> {
        return repository.getLocations()
    }
}
