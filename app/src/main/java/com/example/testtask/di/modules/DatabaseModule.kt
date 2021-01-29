package com.example.testtask.di.modules

import android.content.Context
import androidx.room.Room
import com.example.testtask.data.db.TestDatabase
import com.example.testtask.data.db.dao.CivilizationDao
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


@Module
class DatabaseModule {
    private val mDBName: String = "test_db"

    @Inject
    @Singleton
    @Provides
    fun provideDatabase(context: Context): TestDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TestDatabase::class.java,
            mDBName
        ).build()
    }

    @Inject
    @Singleton
    @Provides
    fun provideCivilizationDao(db: TestDatabase): CivilizationDao {
        return db.civilizationDao
    }
}