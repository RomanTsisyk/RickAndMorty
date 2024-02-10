//package io.github.romantsisyk.rickandmortyrepositorylib.repository
//
//import io.github.romantsisyk.rickandmortyrepositorylib.model.Character
//import io.github.romantsisyk.rickandmortyrepositorylib.model.Episode
//import io.github.romantsisyk.rickandmortyrepositorylib.model.Location
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//class RickAndMortyRepositoryImpl(
//    private val characterDao: CharacterDao,
//    private val episodeDao: EpisodeDao,
//    private val locationDao: LocationDao
//) : RickAndMortyRepository {
//
//    override suspend fun getCharacters(): List<Character> = withContext(Dispatchers.IO) {
//        characterDao.getAllCharacters().map { entity ->
//            Character(
//                id = entity.id,
//                name = entity.name,
//                status = entity.status,
//                species = entity.species,
//                type = entity.type,
//                gender = entity.gender
//            )
//        }
//    }
//
//    override suspend fun getEpisodes(): List<Episode> = withContext(Dispatchers.IO) {
//        episodeDao.getAllEpisodes().map { entity ->
//            Episode(
//                id = entity.id,
//                name = entity.name,
//                airDate = entity.airDate,
//                episodeCode = entity.episode
//            )
//        }
//    }
//
//    override suspend fun getLocations(): List<Location> = withContext(Dispatchers.IO) {
//        locationDao.getAllLocations().map { entity ->
//            Location(
//                id = entity.id,
//                name = entity.name,
//                type = entity.type,
//                dimension = entity.dimension
//            )
//        }
//    }
//}