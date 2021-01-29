package com.example.testtask.data.repositories.ageOfEmpires

import androidx.lifecycle.LiveData
import com.example.testtask.data.models.Civilization
import com.example.testtask.data.models.CivilizationsList
import kotlinx.coroutines.Deferred


interface ICivilizationsTwoWayRepository {
    fun getCivilizations(): LiveData<List<Civilization>>
    fun saveCivilizations(civilizations: List<Civilization>)
    suspend fun getCivilizationsFromAPIAsync(): Deferred<CivilizationsList>
}