package com.roman_tsisyk.rickandmortydatabasemodule.episode

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EpisodeDao {
    @Query("SELECT * FROM EpisodeEntity")
    fun getAllEpisodes(): LiveData<List<EpisodeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(episodes: List<EpisodeEntity>)
}