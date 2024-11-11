package io.github.romantsisyk.rickandmortyapilib.domain.usecase

import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyapilib.domain.model.Episode

/**
 * Use case for retrieving a list of episodes from the repository.
 *
 * @property repository The [RickAndMortyRepository] used to fetch episode data.
 */
class GetEpisodesUseCase(private val repository: RickAndMortyRepository) {

    /**
     * Invokes the use case to get a list of episodes.
     *
     * @return List of [Episode] containing episode details.
     */
    suspend operator fun invoke(): List<Episode> {
        return repository.getEpisodes()
    }
}
