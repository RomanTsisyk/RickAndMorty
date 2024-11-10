package io.github.romantsisyk.rickandmortyrepositoryib.di


import io.github.romantsisyk.rickandmortydatabaselib.dao.CharacterDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.EpisodeDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.LocationDao
import io.github.romantsisyk.rickandmortyrepositoryib.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyrepositoryib.repository.RickAndMortyRepositoryImpl

class RepositoryProvider {
    fun provideRickAndMortyRepository(
        characterDao: CharacterDao,
        episodeDao: EpisodeDao,
        locationDao: LocationDao
    ): RickAndMortyRepository {
        return RickAndMortyRepositoryImpl(characterDao, episodeDao, locationDao)
    }
}