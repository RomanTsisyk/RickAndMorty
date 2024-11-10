package io.github.romantsisyk.rickandmortyapilib.domain.usecase

import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyapilib.domain.model.Character

class GetCharactersUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(): List<Character> {
        return repository.getCharacters()
    }
}