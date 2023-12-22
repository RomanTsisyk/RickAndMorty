package com.roman_tsisyk.rickandmortyapimodule


import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyServiceTest {

    private lateinit var service: RickAndMortyService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyService::class.java)
    }

    @Test
    fun `test getCharacters returns expected data`() = runBlocking {
        val mockResponse = MockResponse()
        val mockJsonResponse = """
    {
      "info": {
        "count": 2,
        "pages": 1,
        "next": null,
        "prev": null
      },
      "results": [
        {
          "id": 1,
          "name": "Rick Sanchez",
          "status": "Alive",
          "species": "Human",
          "type": "",
          "gender": "Male",
          "origin": {
            "name": "Earth",
            "url": "https://rickandmortyapi.com/api/location/1"
          },
          "location": {
            "name": "Earth",
            "url": "https://rickandmortyapi.com/api/location/20"
          },
          "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          "episode": [
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2"
          ],
          "url": "https://rickandmortyapi.com/api/character/1",
          "created": "2017-11-04T18:48:46.250Z"
        },
        {
          "id": 2,
          "name": "Morty Smith",
          "status": "Alive",
          "species": "Human",
          "type": "",
          "gender": "Male",
          "origin": {
            "name": "Earth",
            "url": "https://rickandmortyapi.com/api/location/1"
          },
          "location": {
            "name": "Earth",
            "url": "https://rickandmortyapi.com/api/location/20"
          },
          "image": "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
          "episode": [
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2"
          ],
          "url": "https://rickandmortyapi.com/api/character/2",
          "created": "2017-11-04T18:50:21.651Z"
        }
      ]
    }
""".trimIndent()

        mockResponse.setBody(mockJsonResponse)
        mockWebServer.enqueue(mockResponse)

        val response = service.getCharacters()
        assertEquals("Rick Sanchez", response.results.first().name)

        val request = mockWebServer.takeRequest()
        assertEquals("/character", request.path)
    }

    @Test
    fun `test getEpisodes returns expected data`() = runBlocking {
        // Mock response for episodes
        val mockEpisodesResponse = """
    {
      "info": {
        "count": 1,
        "pages": 1,
        "next": null,
        "prev": null
      },
      "results": [
        {
          "id": 1,
          "name": "Pilot",
          "air_date": "December 2, 2013",
          "episode": "S01E01",
          "characters": ["https://rickandmortyapi.com/api/character/1"],
          "url": "https://rickandmortyapi.com/api/episode/1",
          "created": "2017-11-10T12:56:33.798Z"
        }
      ]
    }
    """.trimIndent()
        val mockResponse = MockResponse()
        mockResponse.setBody(mockEpisodesResponse)
        mockWebServer.enqueue(mockResponse)

        val response = service.getEpisodes()

        assertEquals("Pilot", response.results.first().name)

        val request = mockWebServer.takeRequest()
        assertEquals("/episode", request.path)
    }


    @Test
    fun `test getLocations returns expected data`() = runBlocking {
        // Mock response for locations
        val mockLocationsResponse = """
    {
      "info": {
        "count": 1,
        "pages": 1,
        "next": null,
        "prev": null
      },
      "results": [
        {
          "id": 1,
          "name": "Earth (C-137)",
          "type": "Planet",
          "dimension": "Dimension C-137",
          "residents": ["https://rickandmortyapi.com/api/character/1"],
          "url": "https://rickandmortyapi.com/api/location/1",
          "created": "2017-11-10T12:42:04.162Z"
        }
      ]
    }
    """.trimIndent()
        val mockResponse = MockResponse()
        mockResponse.setBody(mockLocationsResponse)
        mockWebServer.enqueue(mockResponse)

        val response = service.getLocations()
        assertEquals("Earth (C-137)", response.results.first().name)

        val request = mockWebServer.takeRequest()
        assertEquals("/location", request.path)
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
