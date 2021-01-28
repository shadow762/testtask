package com.example.testtask.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Civilization(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("expansion")
    @Expose
    val expansion: String,
    @SerializedName("army_type")
    @Expose
    val army_type: String,
    @SerializedName("unique_unit")
    @Expose
    val unique_unit: List<String>,
    @SerializedName("unique_tech")
    @Expose
    val unique_tech: List<String>,
    @SerializedName("team_bonus")
    @Expose
    val team_bonus: String,
    @SerializedName("civilization_bonus")
    @Expose
    val civilization_bonus: List<String>

)