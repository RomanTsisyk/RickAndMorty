//package io.github.romantsisyk.rickandmortyrepositorylib.di
//
//
//import io.github.romantsisyk.rickandmortyrepositorylib.repository.RickAndMortyRepository
//import io.github.romantsisyk.rickandmortyrepositorylib.repository.RickAndMortyRepositoryImpl
//
//class RepositoryProvider {
//    fun provideRickAndMortyRepository(
//        characterDao: CharacterDao,
//        episodeDao: EpisodeDao,
//        locationDao: LocationDao
//    ): RickAndMortyRepository {
//        return RickAndMortyRepositoryImpl(characterDao, episodeDao, locationDao)
//    }
//}