package com.roman_tsisyk.rickandmortydatabasemodule

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roman_tsisyk.rickandmortydatabasemodule.character.CharacterDao
import com.roman_tsisyk.rickandmortydatabasemodule.character.CharacterEntity
import com.roman_tsisyk.rickandmortydatabasemodule.episode.EpisodeDao
import com.roman_tsisyk.rickandmortydatabasemodule.episode.EpisodeEntity
import com.roman_tsisyk.rickandmortydatabasemodule.location.LocationDao
import com.roman_tsisyk.rickandmortydatabasemodule.location.LocationEntity

@Database(
    entities = [CharacterEntity::class, LocationEntity::class, EpisodeEntity::class],
    version = 1
)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao
}
