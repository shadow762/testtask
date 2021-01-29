package com.example.testtask.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testtask.data.models.Civilization
import com.example.testtask.data.repositories.ageOfEmpires.ICivilizationsTwoWayRepository
import com.example.testtask.ui.global.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val civilizationsRepository: ICivilizationsTwoWayRepository,
) : BaseViewModel() {
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    val civilizationsList: LiveData<List<Civilization>> = civilizationsRepository.getCivilizations()

    fun refreshCivilizations() {
        viewModelScope.launch {
            withContext(IO) {
                _loading.postValue(true)
                val civilizations = civilizationsRepository.getCivilizationsFromAPIAsync().await().civilizations
                civilizationsRepository.saveCivilizations(civilizations)

                _loading.postValue(false)
            }
        }
    }
}