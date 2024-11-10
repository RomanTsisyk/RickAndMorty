//package io.github.romantsisyk.rickandmortyrepositorylib.di
//
//
//import io.github.romantsisyk.rickandmortyapilib.data.api.RickAndMortyService
//import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
//import io.github.romantsisyk.rickandmortydatabaselib.dao.CharacterDao
//import io.github.romantsisyk.rickandmortydatabaselib.dao.EpisodeDao
//import io.github.romantsisyk.rickandmortydatabaselib.dao.LocationDao
//import io.github.romantsisyk.rickandmortyrepositoryib.repository.RickAndMortyRepositoryImpl
//import io.github.romantsisyk.rickandmortyrepositoryib.util.ConnectivityChecker
//
//class RepositoryProvider {
//
//    private var repository: RickAndMortyRepository? = null
//
//    fun provideRepository(
//        characterDao: CharacterDao,
//        episodeDao: EpisodeDao,
//        locationDao: LocationDao,
//        service: RickAndMortyService,
//        connectivityChecker: ConnectivityChecker
//    ): RickAndMortyRepository {
//        return repository ?: synchronized(this) {
//            repository ?: RickAndMortyRepositoryImpl(
//                characterDao = characterDao,
//                episodeDao = episodeDao,
//                locationDao = locationDao,
//                service = service,
//                connectivityChecker = connectivityChecker
//            ).also { repository = it }
//        }
//    }
//
//    fun reset() {
//        repository = null
//    }
//}