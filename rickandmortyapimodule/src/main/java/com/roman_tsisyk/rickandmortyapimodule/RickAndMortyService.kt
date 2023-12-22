package com.roman_tsisyk.rickandmortyapimodule

import com.roman_tsisyk.rickandmortyapimodule.model.Character
import com.roman_tsisyk.rickandmortyapimodule.model.CharactersResponse
import com.roman_tsisyk.rickandmortyapimodule.model.Episode
import com.roman_tsisyk.rickandmortyapimodule.model.EpisodesResponse
import com.roman_tsisyk.rickandmortyapimodule.model.Location
import com.roman_tsisyk.rickandmortyapimodule.model.LocationsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int? = null,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("species") species: String? = null,
        @Query("type") type: String? = null,
        @Query("gender") gender: String? = null
    ): CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Character

    @GET("location")
    suspend fun getLocations(
        @Query("page") page: Int? = null,
        @Query("name") name: String? = null,
        @Query("type") type: String? = null,
        @Query("dimension") dimension: String? = null
    ): LocationsResponse

    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): Location

    @GET("episode")
    suspend fun getEpisodes(
        @Query("page") page: Int? = null,
        @Query("name") name: String? = null,
        @Query("episode") episode: String? = null
    ): EpisodesResponse

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): Episode

}
