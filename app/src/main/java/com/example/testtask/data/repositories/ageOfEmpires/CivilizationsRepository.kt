package com.example.testtask.data.repositories.ageOfEmpires

import com.example.testtask.data.models.CivilizationsList
import com.example.testtask.data.network.ApiDao
import kotlinx.coroutines.Deferred
import javax.inject.Inject

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class CivilizationsRepository @Inject constructor(private val apiDao: ApiDao): ICivilizationsRepository {
    override suspend fun getCivilizationsAsync(): Deferred<CivilizationsList> {
        return apiDao.getCivilizationsAsync()
    }
}