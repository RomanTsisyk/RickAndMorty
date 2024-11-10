package io.github.romantsisyk.rickandmortyapilib.data.repository

import  io.github.romantsisyk.rickandmortyapilib.domain.model.Character
import  io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyapilib.data.api.RickAndMortyService
import io.github.romantsisyk.rickandmortyapilib.domain.model.Episode
import io.github.romantsisyk.rickandmortyapilib.domain.model.Location

class RickAndMortyRepositoryImpl(
    private val service: RickAndMortyService
) : RickAndMortyRepository {
    override suspend fun getCharacters(): List<Character> {
        val response = service.getCharacters()
        return response.results.map { entity ->
            Character(id = entity.id, name = entity.name, status = entity.status)
        }
    }

    override suspend fun getEpisodes(): List<Episode> {
        val response = service.getEpisodes()
        return response.results.map { entity ->
            Episode(id = entity.id, name = entity.name, episodeCode = entity.episode)
        }
    }

    override suspend fun getLocations(): List<Location> {
        val response = service.getLocations()
        return response.results.map { entity ->
            Location(id = entity.id, name = entity.name, type = entity.type)
        }
    }
}