package io.github.romantsisyk.rickandmortydatabaselib.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.romantsisyk.rickandmortydatabaselib.dao.CharacterDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.EpisodeDao
import io.github.romantsisyk.rickandmortydatabaselib.dao.LocationDao
import io.github.romantsisyk.rickandmortydatabaselib.entity.CharacterEntity
import io.github.romantsisyk.rickandmortydatabaselib.entity.EpisodeEntity
import io.github.romantsisyk.rickandmortydatabaselib.entity.LocationEntity

@Database(
    entities = [CharacterEntity::class, EpisodeEntity::class, LocationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RickAndMortyDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao

    companion object {
        @Volatile
        private var INSTANCE: RickAndMortyDatabase? = null

        fun getInstance(context: Context): RickAndMortyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RickAndMortyDatabase::class.java,
                    "rick_and_morty_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}