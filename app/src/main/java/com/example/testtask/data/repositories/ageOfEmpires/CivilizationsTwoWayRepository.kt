package com.example.testtask.data.repositories.ageOfEmpires

import androidx.lifecycle.LiveData
import com.example.testtask.data.db.dao.CivilizationDao
import com.example.testtask.data.models.Civilization
import com.example.testtask.data.models.CivilizationsList
import com.example.testtask.data.network.ApiDao
import kotlinx.coroutines.Deferred
import javax.inject.Inject

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class CivilizationsTwoWayRepository @Inject constructor(private val apiDao: ApiDao, private val localCivilizationDao: CivilizationDao): ICivilizationsTwoWayRepository {
    override fun getCivilizations(): LiveData<List<Civilization>> {
        return localCivilizationDao.getCivilizations()
    }

    override fun saveCivilizations(civilizations: List<Civilization>) {
        localCivilizationDao.insert(civilizations)
    }

    override suspend fun getCivilizationsFromAPIAsync(): Deferred<CivilizationsList> {
        return apiDao.getCivilizationsAsync()
    }
}