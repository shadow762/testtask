package com.example.testtask.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.testtask.data.models.Civilization

@Dao
interface CivilizationDao {
    @Query("select * from civilizations")
    fun getCivilizations(): LiveData<List<Civilization>>

    @Insert(onConflict = REPLACE)
    fun insert(civilization: Civilization) : Long

    @Insert(onConflict = REPLACE)
    fun insert(civilizations: List<Civilization>)
}