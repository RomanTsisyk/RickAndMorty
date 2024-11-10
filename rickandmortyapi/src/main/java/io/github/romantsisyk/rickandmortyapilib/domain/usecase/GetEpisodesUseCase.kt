package io.github.romantsisyk.rickandmortyapilib.domain.usecase

import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyapilib.domain.model.Episode

class GetEpisodesUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(): List<Episode> {
        return repository.getEpisodes()
    }
}