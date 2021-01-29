package com.example.testtask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtask.data.db.dao.CivilizationDao
import com.example.testtask.data.models.Civilization

@Database(entities = [
    Civilization::class,
], version = 1)
abstract class TestDatabase: RoomDatabase() {
    abstract val civilizationDao: CivilizationDao
}