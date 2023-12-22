package com.roman_tsisyk.rickandmortyapimodule

import androidx.lifecycle.ViewModel
import com.roman_tsisyk.rickandmortyapimodule.model.CharactersResponse
import com.roman_tsisyk.rickandmortyapimodule.model.EpisodesResponse
import com.roman_tsisyk.rickandmortyapimodule.model.LocationsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class RickAndMortyViewModel : ViewModel() {
    private val apiManager = RickAndMortyApiManager(viewModelScope)

    private val _characters = MutableStateFlow<Result<CharactersResponse>?>(null)
    val characters: StateFlow<Result<CharactersResponse>?> = _characters

    private val _locations = MutableStateFlow<Result<LocationsResponse>?>(null)
    val locations: StateFlow<Result<LocationsResponse>?> = _locations

    private val _episodes = MutableStateFlow<Result<EpisodesResponse>?>(null)
    val episodes: StateFlow<Result<EpisodesResponse>?> = _episodes

    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = apiManager.getAllCharacters()
                _characters.value = response
            } catch (e: Exception) {
                _characters.value = Result.failure(e)
            }
        }
    }

    fun fetchLocations() {
        viewModelScope.launch {
            try {
                val response = apiManager.getAllLocations()
                _locations.value = response
            } catch (e: Exception) {
                _locations.value = Result.failure(e)
            }
        }
    }

    fun fetchEpisodes() {
        viewModelScope.launch {
            try {
                val response = apiManager.getAllEpisodes()
                _episodes.value = response
            } catch (e: Exception) {
                _episodes.value = Result.failure(e)
            }
        }
    }
}
