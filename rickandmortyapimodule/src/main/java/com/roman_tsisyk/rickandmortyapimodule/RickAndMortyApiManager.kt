package com.roman_tsisyk.rickandmortyapimodule

import com.roman_tsisyk.rickandmortyapimodule.model.Character
import com.roman_tsisyk.rickandmortyapimodule.model.CharactersResponse
import com.roman_tsisyk.rickandmortyapimodule.model.Episode
import com.roman_tsisyk.rickandmortyapimodule.model.EpisodesResponse
import com.roman_tsisyk.rickandmortyapimodule.model.Location
import com.roman_tsisyk.rickandmortyapimodule.model.LocationsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class RickAndMortyApiManager(private val scope: CoroutineScope) {

    private val service: RickAndMortyService =
        RetrofitClient.retrofit.create(RickAndMortyService::class.java)

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return withContext(scope.coroutineContext) {
            try {
                Result.success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        // Handle HTTP errors here
                        Result.failure(RuntimeException("Server error"))
                    }

                    else -> {
                        // Handle other errors (like network issues)
                        Result.failure(RuntimeException("Network error"))
                    }
                }
            }
        }
    }

    suspend fun getAllCharacters(): Result<CharactersResponse> =
        safeApiCall { service.getCharacters() }

    suspend fun getCharacterById(id: Int): Result<Character> =
        safeApiCall { service.getCharacterById(id) }

    suspend fun getAllLocations(
        page: Int? = null,
        name: String? = null,
        type: String? = null,
        dimension: String? = null
    ): Result<LocationsResponse> =
        safeApiCall {
            service.getLocations(page, name, type, dimension)
        }

    suspend fun getLocationById(id: Int): Result<Location> =
        safeApiCall { service.getLocationById(id) }

    suspend fun getAllEpisodes(): Result<EpisodesResponse> {
        return safeApiCall { service.getEpisodes() }
    }

    suspend fun getEpisodeById(id: Int): Result<Episode> {
        return safeApiCall { service.getEpisodeById(id) }
    }
}
