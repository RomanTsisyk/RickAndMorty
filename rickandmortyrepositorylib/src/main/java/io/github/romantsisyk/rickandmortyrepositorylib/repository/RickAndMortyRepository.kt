package io.github.romantsisyk.rickandmortyrepositorylib.repository

import io.github.romantsisyk.rickandmortyrepositorylib.model.Character
import io.github.romantsisyk.rickandmortyrepositorylib.model.Episode
import io.github.romantsisyk.rickandmortyrepositorylib.model.Location

interface RickAndMortyRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getEpisodes(): List<Episode>
    suspend fun getLocations(): List<Location>
}