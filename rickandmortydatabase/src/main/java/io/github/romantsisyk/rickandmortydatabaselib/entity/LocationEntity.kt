package io.github.romantsisyk.rickandmortydatabaselib.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)