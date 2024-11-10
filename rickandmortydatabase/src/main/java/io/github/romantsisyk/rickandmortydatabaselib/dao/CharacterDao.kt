package io.github.romantsisyk.rickandmortydatabaselib.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.romantsisyk.rickandmortydatabaselib.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: Int): CharacterEntity?

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Query("DELETE FROM characters")
    suspend fun clearCharacters()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCharacters(characters: List<CharacterEntity>)

}