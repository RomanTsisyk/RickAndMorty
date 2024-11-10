package io.github.romantsisyk.rickandmortyapilib


import io.github.romantsisyk.rickandmortyapilib.data.api.RickAndMortyServiceImpl
import io.github.romantsisyk.rickandmortyapilib.data.network.NetworkClient
import io.github.romantsisyk.rickandmortyapilib.data.repository.RickAndMortyRepositoryImpl
import io.github.romantsisyk.rickandmortyapilib.domain.repository.RickAndMortyRepository
import io.github.romantsisyk.rickandmortyapilib.domain.usecase.GetCharactersUseCase
import io.github.romantsisyk.rickandmortyapilib.domain.usecase.GetEpisodesUseCase
import io.github.romantsisyk.rickandmortyapilib.domain.usecase.GetLocationsUseCase

object DependencyInjector {
    private val httpClient = NetworkClient.client
    private val rickAndMortyService = RickAndMortyServiceImpl(httpClient)
    private val rickAndMortyRepository: RickAndMortyRepository = RickAndMortyRepositoryImpl(rickAndMortyService)

    val getCharactersUseCase = GetCharactersUseCase(rickAndMortyRepository)
    val getEpisodesUseCase = GetEpisodesUseCase(rickAndMortyRepository)
    val getLocationsUseCase = GetLocationsUseCase(rickAndMortyRepository)
}