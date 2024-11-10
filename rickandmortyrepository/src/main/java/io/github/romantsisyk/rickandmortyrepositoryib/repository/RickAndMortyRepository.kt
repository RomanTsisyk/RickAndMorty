package io.github.romantsisyk.rickandmortyrepositoryib.repository

import io.github.romantsisyk.rickandmortyrepositoryib.model.Character
import io.github.romantsisyk.rickandmortyrepositoryib.model.Episode
import io.github.romantsisyk.rickandmortyrepositoryib.model.Location
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getEpisodes(): List<Episode>
    suspend fun getLocations(): List<Location>
}