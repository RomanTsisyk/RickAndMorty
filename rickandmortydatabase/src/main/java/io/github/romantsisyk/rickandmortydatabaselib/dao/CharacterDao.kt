package io.github.romantsisyk.rickandmortydatabaselib.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.romantsisyk.rickandmortydatabaselib.entity.CharacterEntity

/**
 * DAO for accessing character data in the database.
 */
@Dao
interface CharacterDao {

    /**
     * Inserts or replaces a character in the database.
     *
     * @param character The [CharacterEntity] to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    /**
     * Retrieves a character by its ID.
     *
     * @param id The ID of the character to retrieve.
     * @return The [CharacterEntity] with the specified ID, or null if not found.
     */
    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: Int): CharacterEntity?

    /**
     * Retrieves all characters from the database.
     *
     * @return A list of all [CharacterEntity] instances.
     */
    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<CharacterEntity>

    /**
     * Clears all character data from the database.
     */
    @Query("DELETE FROM characters")
    suspend fun clearCharacters()

    /**
     * Inserts or replaces a list of characters in the database.
     *
     * @param characters The list of [CharacterEntity] instances to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(characters: List<CharacterEntity>)
}
