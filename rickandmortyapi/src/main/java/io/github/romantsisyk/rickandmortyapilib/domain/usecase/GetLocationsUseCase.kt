package io.github.romantsisyk.rickandmortyapilib.domain.usecase

import io.github.romantsisyk.rickandmortyapilib.domain.model.Location
import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository

class GetLocationsUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(): List<Location> {
        return repository.getLocations()
    }
}