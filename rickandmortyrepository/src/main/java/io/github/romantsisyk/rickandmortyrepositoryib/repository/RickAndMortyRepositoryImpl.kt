package io.github.romantsisyk.rickandmortyrepositoryib.repository

import io.github.romantsisyk.rickandmortydatabaselib.dao.CharacterDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.EpisodeDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.LocationDao
import io.github.romantsisyk.rickandmortyrepositoryib.model.Character
import io.github.romantsisyk.rickandmortyrepositoryib.model.Episode
import io.github.romantsisyk.rickandmortyrepositoryib.model.Location
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.withContext

class RickAndMortyRepositoryImpl(
    private val characterDao: CharacterDao,
    private val episodeDao: EpisodeDao,
    private val locationDao: LocationDao,
    private val dispatcherIO: CoroutineDispatcher = Dispatchers.IO,
) : RickAndMortyRepository {

    override suspend fun getCharacters(): List<Character> = withContext(dispatcherIO) {
        characterDao.getAllCharacters().map { entity ->
            Character(
                id = entity.id,
                name = entity.name,
                status = entity.status,
                species = entity.species,
                type = entity.type,
                gender = entity.gender
            )
        }
    }

    override suspend fun getEpisodes(): List<Episode> = withContext(dispatcherIO) {
        episodeDao.getAllEpisodes().map { entity ->
            Episode(
                id = entity.id,
                name = entity.name,
                airDate = entity.airDate,
                episodeCode = entity.episode
            )
        }
    }

    override suspend fun getLocations(): List<Location> = withContext(dispatcherIO) {
        locationDao.getAllLocations().map { entity ->
            Location(
                id = entity.id,
                name = entity.name,
                type = entity.type,
                dimension = entity.dimension
            )
        }
    }
}