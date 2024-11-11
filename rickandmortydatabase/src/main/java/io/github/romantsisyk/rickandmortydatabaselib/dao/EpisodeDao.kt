package io.github.romantsisyk.rickandmortydatabaselib.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.romantsisyk.rickandmortydatabaselib.entity.EpisodeEntity

/**
 * DAO for accessing episode data in the database.
 */
@Dao
interface EpisodeDao {

    /**
     * Inserts or replaces an episode in the database.
     *
     * @param episode The [EpisodeEntity] to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: EpisodeEntity)

    /**
     * Retrieves an episode by its ID.
     *
     * @param id The ID of the episode to retrieve.
     * @return The [EpisodeEntity] with the specified ID, or null if not found.
     */
    @Query("SELECT * FROM episodes WHERE id = :id")
    suspend fun getEpisodeById(id: Int): EpisodeEntity?

    /**
     * Retrieves all episodes from the database.
     *
     * @return A list of all [EpisodeEntity] instances.
     */
    @Query("SELECT * FROM episodes")
    suspend fun getAllEpisodes(): List<EpisodeEntity>

    /**
     * Clears all episode data from the database.
     */
    @Query("DELETE FROM episodes")
    suspend fun clearEpisodes()

    /**
     * Inserts or replaces a list of episodes in the database.
     *
     * @param episodes The list of [EpisodeEntity] instances to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(episodes: List<EpisodeEntity>)
}
