package com.example.testtask.data.network

import com.example.testtask.data.models.CivilizationsList
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ApiDao {
    @Headers(
        "Accept: application/json"
    )
    @GET("civilizations")
    fun getCivilizationsAsync(): Deferred<CivilizationsList>
}