package com.kobylynskyiv.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kobylynskyiv.room.model.EntitySection

@Dao
interface SectionDao {

    @Insert
    suspend fun insert(user: EntitySection)

    @Insert
    suspend fun insert(user: List<EntitySection>)

    @Query("DELETE FROM sections")
    suspend fun deleteAll()

    @Query("SELECT * FROM sections")
    suspend fun getAllSections(): List<EntitySection?>?

}