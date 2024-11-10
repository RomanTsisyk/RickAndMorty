package io.github.romantsisyk.rickandmortyrepositoryib.repository

import io.github.romantsisyk.rickandmortyapilib.data.api.RickAndMortyService
import io.github.romantsisyk.rickandmortyapilib.data.model.CharactersResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.EpisodesResponse
import io.github.romantsisyk.rickandmortyapilib.data.model.LocationsResponse
import io.github.romantsisyk.rickandmortydatabaselib.dao.CharacterDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.EpisodeDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.LocationDao
import io.github.romantsisyk.rickandmortydatabaselib.entity.CharacterEntity
import io.github.romantsisyk.rickandmortydatabaselib.entity.EpisodeEntity
import io.github.romantsisyk.rickandmortydatabaselib.entity.LocationEntity
import io.github.romantsisyk.rickandmortyrepositoryib.util.ConnectivityChecker
import io.github.romantsisyk.rickandmortyrepositoryib.model.Character
import io.github.romantsisyk.rickandmortyrepositoryib.model.Episode
import io.github.romantsisyk.rickandmortyrepositoryib.model.Location

class RickAndMortyRepositoryImpl(
    private val characterDao: CharacterDao,
    private val episodeDao: EpisodeDao,
    private val locationDao: LocationDao,
    private val service: RickAndMortyService,
    private val connectivityChecker: ConnectivityChecker,
) : RickAndMortyRepository {

    override suspend fun getCharacters(): List<Character> = fetchDataWithCache(
        databaseQuery = { characterDao.getAllCharacters() },
        networkCall = { service.getCharacters().mapToEntity() },
        saveCallResult = { characterDao.saveCharacters(it) },  // This returns Unit, which is fine
        mapEntityToDomain = { it.toDomainModel() }
    )

    override suspend fun getEpisodes(): List<Episode> = fetchDataWithCache(
        databaseQuery = { episodeDao.getAllEpisodes() },
        networkCall = { service.getEpisodes().mapToEntity() },
        saveCallResult = { episodeDao.saveEpisodes(it) },
        mapEntityToDomain = { it.toDomainModel() }
    )

    override suspend fun getLocations(): List<Location> = fetchDataWithCache(
        databaseQuery = { locationDao.getAllLocations() },
        networkCall = { service.getLocations().mapToEntity() },
        saveCallResult = { locationDao.saveLocations(it) },
        mapEntityToDomain = { it.toDomainModel() }
    )


    private suspend fun <T, E> fetchDataWithCache(
        databaseQuery: suspend () -> List<E>,
        networkCall: suspend () -> List<E>,
        saveCallResult: suspend (List<E>) -> Unit,
        mapEntityToDomain: (E) -> T,
    ): List<T> {
        return if (connectivityChecker.isConnected()) {
            try {
                val networkData = networkCall()
                saveCallResult(networkData)
                networkData.map(mapEntityToDomain)
            } catch (e: Exception) {
                databaseQuery().map(mapEntityToDomain)
            }
        } else {
            databaseQuery().map(mapEntityToDomain)
        }
    }
}

private fun CharacterEntity.toDomainModel(): Character = Character(id, name, status, species, type, gender)
private fun EpisodeEntity.toDomainModel(): Episode = Episode(id, name, airDate, "episodeCode")
private fun LocationEntity.toDomainModel(): Location = Location(id, name, type, dimension)

private fun CharactersResponse.mapToEntity(): List<CharacterEntity> = results.map { CharacterEntity(it.id, it.name, it.status, it.species, "it.type", "it.gender") }
private fun EpisodesResponse.mapToEntity(): List<EpisodeEntity> = results.map { EpisodeEntity(it.id, it.name, "it.airDate", it.episode) }
private fun LocationsResponse.mapToEntity(): List<LocationEntity> = results.map { LocationEntity(it.id, it.name, it.type, "it.dimension") }
