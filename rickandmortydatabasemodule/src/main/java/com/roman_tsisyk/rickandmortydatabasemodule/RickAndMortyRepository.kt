package com.roman_tsisyk.rickandmortydatabasemodule

import com.roman_tsisyk.rickandmortydatabasemodule.character.CharacterDao
import com.roman_tsisyk.rickandmortydatabasemodule.episode.EpisodeDao
import com.roman_tsisyk.rickandmortydatabasemodule.location.LocationDao

class RickAndMortyRepository(
    private val characterDao: CharacterDao,
    private val locationDao: LocationDao,
    private val episodeDao: EpisodeDao
) {
    fun getAllCharacters() = characterDao.getAllCharacters()
    fun getAllLocations() = locationDao.getAllLocations()
    fun getAllEpisodes() = episodeDao.getAllEpisodes()
}
