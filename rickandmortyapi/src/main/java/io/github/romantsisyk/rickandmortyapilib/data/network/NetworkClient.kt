package io.github.romantsisyk.rickandmortyapilib.data.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

/**
 * NetworkClient is an object providing a configured [HttpClient] instance for network requests.
 *
 * This client is configured with:
 * - Content negotiation for JSON deserialization using kotlinx.serialization.
 * - Logging plugin to log request and response bodies for debugging purposes.
 */
object NetworkClient {

    /**
     * A singleton [HttpClient] instance configured with:
     * - [CIO] engine for coroutine-based I/O.
     * - Content negotiation to handle JSON responses.
     * - Logging for body-level information on requests and responses.
     */
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Ignore unknown JSON fields for flexible parsing
                isLenient = true         // Allow lenient parsing of JSON responses
            })
        }
        install(Logging) {
            level = LogLevel.BODY       // Log request and response bodies
        }
    }
}