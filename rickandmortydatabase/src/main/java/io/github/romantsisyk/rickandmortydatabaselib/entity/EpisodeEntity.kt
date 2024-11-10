package io.github.romantsisyk.rickandmortydatabaselib.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class EpisodeEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val airDate: String,
    val episode: String
)