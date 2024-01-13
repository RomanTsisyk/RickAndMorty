package io.github.romantsisyk.rickandmortyapilib.domain.repository

import io.github.romantsisyk.rickandmortyapilib.domain.model.Episode
import io.github.romantsisyk.rickandmortyapilib.domain.model.Location
import io.github.romantsisyk.rickandmortyapilib.domain.model.Character


interface RickAndMortyRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getEpisodes(): List<Episode>
    suspend fun getLocations(): List<Location>
}