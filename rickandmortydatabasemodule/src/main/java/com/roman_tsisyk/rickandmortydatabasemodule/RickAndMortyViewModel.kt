package com.roman_tsisyk.rickandmortydatabasemodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.roman_tsisyk.rickandmortydatabasemodule.character.CharacterEntity
import com.roman_tsisyk.rickandmortydatabasemodule.episode.EpisodeEntity
import com.roman_tsisyk.rickandmortydatabasemodule.location.LocationEntity

class RickAndMortyViewModel(private val repository: RickAndMortyRepository) : ViewModel() {

    val characters: LiveData<List<CharacterEntity>> = repository.getAllCharacters()
    val locations: LiveData<List<LocationEntity>> = repository.getAllLocations()
    val episodes: LiveData<List<EpisodeEntity>> = repository.getAllEpisodes()
}
