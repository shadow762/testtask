package com.example.testtask.data.repositories.ageOfEmpires

import com.example.testtask.data.models.CivilizationsList
import kotlinx.coroutines.Deferred


interface ICivilizationsRepository {
    suspend fun getCivilizationsAsync(): Deferred<CivilizationsList>
}