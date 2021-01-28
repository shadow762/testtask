package com.example.testtask.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CivilizationsList(
    @SerializedName("civilizations")
    @Expose
    val civilizations: List<Civilization>
)