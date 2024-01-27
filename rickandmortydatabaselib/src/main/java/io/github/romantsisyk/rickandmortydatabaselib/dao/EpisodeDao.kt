package io.github.romantsisyk.rickandmortydatabaselib.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.romantsisyk.rickandmortydatabaselib.entity.EpisodeEntity

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: EpisodeEntity)

    @Query("SELECT * FROM episodes WHERE id = :id")
    suspend fun getEpisodeById(id: Int): EpisodeEntity?

    @Query("SELECT * FROM episodes")
    suspend fun getAllEpisodes(): List<EpisodeEntity>

    @Query("DELETE FROM episodes")
    suspend fun clearEpisodes()
}