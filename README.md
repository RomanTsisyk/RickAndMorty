# Multi-Module Project with Android and Kotlin Libraries

This repository demonstrates a multi-module project setup for an Android application, designed to test concepts and best practices in modular architecture. It includes:

- **Two Android libraries**: Separate modules for API and database functionality, structured to maintain a **clean architecture**.
- **One Kotlin library**: A platform-agnostic module that can be used across Android and non-Android projects, following **Kotlin best practices**.

### Project Purpose
This project was created as part of my preparation for a Senior SDK Engineer role. It showcases the implementation of a single source of truth pattern, modularization, dependency injection, and clean architecture principles on a small scale, simulating SDK development practices in a realistic setup.

### Modules Overview
- **API Module**: Handles network interactions and communicates with external APIs, providing structured responses.
- **Database Module**: Manages local data storage using Room, ensuring offline functionality and data persistence.
- **Repository Module**: Implements the single source of truth pattern, coordinating between the API and database modules to deliver reliable data to the application layer.

### Features
- **Multi-Module Architecture**: Promotes separation of concerns, allowing each module to focus on specific tasks and making the codebase more maintainable and scalable.
- **Single Source of Truth**: The repository module prioritizes cached data and only fetches from the network when necessary, caching results to maintain a resilient and efficient data flow.
- **Dependency Injection**: Supports modular design, enabling seamless testing and reducing dependencies between modules.

### Future Enhancements
- **Add UI Module**: Integrate a small UI layer to demonstrate a complete application flow using the modular setup.
- **Extend Repository Logic**: Add more caching strategies and further optimize the single source of truth pattern.


## Project Overview

The project is based on **Rick and Morty** data and includes modules for fetching and managing data about characters, episodes, and locations from the Rick and Morty API. The end goal of the project is to provide a modular SDK that can be reused in different applications. A small UI demo application will be added later to showcase the usage of the SDK.

## Modules

This project is organized into multiple modules to support modularity and reusability. Each module has its own specific responsibilities:

### 1. **rickandmortydatabaselib**
   - **Type**: Android Library (Room database)
   - **Description**: Handles local data storage using Room, providing DAOs for accessing character, episode, and location data. 
   - **Purpose**: Ensures offline access and caching of Rick and Morty data.

### 2. **rickandmortyrepository**
   - **Type**: Kotlin Library
   - **Description**: A Kotlin-based library that provides a repository implementation following clean architecture. It interacts with both `rickandmortydatabase` for local data and `rickandmortyapilib` for network data.
   - **Purpose**: Acts as an abstraction layer, exposing a clean API for data access without revealing underlying data sources (API or database).

### 3. **rickandmortyapilib**
   - **Type**: Kotlin Library
   - **Description**: This SDK module provides access to the Rick and Morty API, handling network requests and data mapping.
   - **Purpose**: Supplies data from the network to the `rickandmortyrepository` module.

### 4. **app**
   - **Type**: Android Application
   - **Description**: (Planned) This module will include a small UI for demonstrating the SDK’s capabilities.
   - **Purpose**: Provides a visual demo of the SDK functionalities, such as displaying characters, episodes, and locations.

## Architecture

The project follows **Clean Architecture** principles with three main layers:

1. **Data Layer**:
   - Contains `rickandmortydatabase` and `rickandmortyapilib` modules.
   - The `rickandmortyrepository` module acts as the primary data access point, connecting the data sources (API and database) and exposing them to the rest of the app.

2. **Domain Layer**:
   - Contains core business models and repository interfaces, decoupled from data sources.
   - Implements use cases for fetching Rick and Morty data, exposing data retrieval in a structured and business-logic-focused way.

3. **Presentation Layer** (Planned):
   - Will contain ViewModels and UI components in the `app` module to display data.

## Key Components

- **Repository Pattern**: The `RickAndMortyRepository` provides a single access point for data retrieval, combining data from the local database and API as needed.
- **Room Database**: The `rickandmortydatabase` module uses Room to manage offline data storage.
- **Modular Architecture**: Each feature is split into separate modules, making the SDK flexible and reusable in other projects.
- **Unit Testing**: Unit tests are created using JUnit, Mockk, and Coroutine Test to ensure that each module works independently and reliably.

## Future Plans
- **UI Demo**: Build a small demo app to showcase the usage of the SDK.
- **Improved Error Handling**: Add detailed error handling in the repository layer.
- **Network Caching**: Implement network caching to improve performance.
- **Documentation**: Add Javadoc comments for public functions and classes.

  
### Project Structure Visualization
Here’s a visual representation of the project structure, illustrating the relationship between each module:

```
RickAndMortySDK Project
├── app                    # Planned UI demo application
│
├── rickandmortydatabase   # Database Library (Android)
│   ├── dao                # Room DAO interfaces (CharacterDao, EpisodeDao, LocationDao)
│   ├── entity             # Room entities (CharacterEntity, EpisodeEntity, LocationEntity)
│   └── RickAndMortyDatabase.kt  # Room database setup with DAO providers
│
├── rickandmortyapilib     # API Library (Kotlin SDK)
│   ├── data
│   │   ├── api            # Network layer (RickAndMortyService, RickAndMortyServiceImpl)
│   │   ├── model          # API data models (e.g., CharactersResponse, EpisodesResponse)
│   │   └── network        # Network client configuration (NetworkClient)
│   └── domain
│       ├── model          # Domain models (Character, Episode, Location)
│       └── usecase        # Use cases (GetCharactersUseCase, GetEpisodesUseCase)
│
├── rickandmortyrepository # Repository Library (Kotlin)
│   ├── repository         # Repository implementation (RickAndMortyRepositoryImpl)
│   ├── model              # Domain models (Character, Episode, Location)
│   └── di                 # Dependency injection setup (RepositoryProvider)
│
└── README.md              # Project documentation```

