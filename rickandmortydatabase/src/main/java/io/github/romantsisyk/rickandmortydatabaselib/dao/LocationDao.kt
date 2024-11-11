package io.github.romantsisyk.rickandmortydatabaselib.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.romantsisyk.rickandmortydatabaselib.entity.LocationEntity

/**
 * DAO for accessing location data in the database.
 */
@Dao
interface LocationDao {

    /**
     * Inserts or replaces a location in the database.
     *
     * @param location The [LocationEntity] to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationEntity)

    /**
     * Retrieves a location by its ID.
     *
     * @param id The ID of the location to retrieve.
     * @return The [LocationEntity] with the specified ID, or null if not found.
     */
    @Query("SELECT * FROM locations WHERE id = :id")
    suspend fun getLocationById(id: Int): LocationEntity?

    /**
     * Retrieves all locations from the database.
     *
     * @return A list of all [LocationEntity] instances.
     */
    @Query("SELECT * FROM locations")
    suspend fun getAllLocations(): List<LocationEntity>

    /**
     * Clears all location data from the database.
     */
    @Query("DELETE FROM locations")
    suspend fun clearLocations()

    /**
     * Inserts or replaces a list of locations in the database.
     *
     * @param locations The list of [LocationEntity] instances to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(locations: List<LocationEntity>)
}
