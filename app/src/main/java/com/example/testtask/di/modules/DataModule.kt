package com.example.testtask.di.modules

import com.example.testtask.data.repositories.ageOfEmpires.CivilizationsRepository
import com.example.testtask.data.repositories.ageOfEmpires.CivilizationsTwoWayRepository
import com.example.testtask.data.repositories.ageOfEmpires.ICivilizationsRepository
import com.example.testtask.data.repositories.ageOfEmpires.ICivilizationsTwoWayRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun provideCivilizationsRepository(civilizationsRepository: CivilizationsRepository): ICivilizationsRepository

    @Binds
    abstract fun provideCivilizationsTwoWayRepository(civilizationsRepository: CivilizationsTwoWayRepository): ICivilizationsTwoWayRepository
}