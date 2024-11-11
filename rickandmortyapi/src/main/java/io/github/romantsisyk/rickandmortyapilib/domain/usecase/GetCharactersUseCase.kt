package io.github.romantsisyk.rickandmortyapilib.domain.usecase

import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyapilib.domain.model.Character

/**
 * Use case for retrieving a list of characters from the repository.
 *
 * @property repository The [RickAndMortyRepository] used to fetch character data.
 */
class GetCharactersUseCase(private val repository: RickAndMortyRepository) {

    /**
     * Invokes the use case to get a list of characters.
     *
     * @return List of [Character] containing character details.
     */
    suspend operator fun invoke(): List<Character> {
        return repository.getCharacters()
    }
}
