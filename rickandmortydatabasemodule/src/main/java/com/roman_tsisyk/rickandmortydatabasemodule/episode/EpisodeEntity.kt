package com.roman_tsisyk.rickandmortydatabasemodule.episode

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EpisodeEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val airDate: String,
    val episodeCode: String
)
