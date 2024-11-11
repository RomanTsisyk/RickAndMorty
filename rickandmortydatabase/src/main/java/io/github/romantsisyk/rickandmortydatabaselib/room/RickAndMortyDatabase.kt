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

/**
 * The main database for the Rick and Morty app, containing DAOs for characters, episodes, and locations.
 */
@Database(
    entities = [CharacterEntity::class, EpisodeEntity::class, LocationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RickAndMortyDatabase : RoomDatabase() {

    /**
     * Provides access to character data operations.
     */
    abstract fun characterDao(): CharacterDao

    /**
     * Provides access to episode data operations.
     */
    abstract fun episodeDao(): EpisodeDao

    /**
     * Provides access to location data operations.
     */
    abstract fun locationDao(): LocationDao

    companion object {
        @Volatile
        private var INSTANCE: RickAndMortyDatabase? = null

        /**
         * Returns a singleton instance of [RickAndMortyDatabase].
         *
         * @param context The application context.
         * @return A singleton instance of [RickAndMortyDatabase].
         */
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
