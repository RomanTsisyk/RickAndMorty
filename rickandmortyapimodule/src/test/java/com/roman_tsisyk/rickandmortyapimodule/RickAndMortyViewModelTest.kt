package com.roman_tsisyk.rickandmortyapimodule

import org.junit.Assert.*

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.Before
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class RickAndMortyViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: RickAndMortyViewModel
    private lateinit var mockApiManager: RickAndMortyApiManager

    @Before
    fun setUp() {
        mockApiManager = mock() // Mocking the API Manager
        viewModel = RickAndMortyViewModel(mockApiManager, testScope)
    }

    @Test
    fun `fetchCharacters updates characters StateFlow`() = testScope.runBlockingTest {
        // Assume that we have a CharactersResponse object
        val mockResponse = CharactersResponse(/* ... */)
        whenever(mockApiManager.getAllCharacters()).thenReturn(mockResponse)

        viewModel.fetchCharacters()

        // Observe the changes
        assertEquals(mockResponse, viewModel.characters.value)
    }

    // Similar tests for fetchLocations and fetchEpisodes
}
