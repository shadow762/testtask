package com.example.testtask.di.modules

import com.example.testtask.data.repositories.ageOfEmpires.CivilizationsRepository
import com.example.testtask.data.repositories.ageOfEmpires.ICivilizationsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun provideCivilizationsRepository(civilizationsRepository: CivilizationsRepository): ICivilizationsRepository
}