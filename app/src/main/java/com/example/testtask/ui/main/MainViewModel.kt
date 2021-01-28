package com.example.testtask.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testtask.data.models.Civilization
import com.example.testtask.data.repositories.ageOfEmpires.ICivilizationsRepository
import com.example.testtask.ui.global.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val civilizationsRepository: ICivilizationsRepository,
) : BaseViewModel() {
    private val _civilizationsList = MutableLiveData<List<Civilization>>()
    val civilizationsList: LiveData<List<Civilization>> = _civilizationsList

    fun getCivilizations() {
        viewModelScope.launch {

            withContext(IO) {
                _civilizationsList.postValue(civilizationsRepository.getCivilizationsAsync().await().civilizations)
            }
        }
    }
}