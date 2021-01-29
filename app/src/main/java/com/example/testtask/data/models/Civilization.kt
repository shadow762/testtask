package com.example.testtask.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "civilizations")
data class Civilization(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("expansion")
    @Expose
    var expansion: String,
    @SerializedName("army_type")
    @Expose
    var armyType: String,
//    @SerializedName("unique_unit")
//    @Expose
//    @Ignore
//    var uniqueUnit: List<String>,
//    @SerializedName("unique_tech")
//    @Expose
//    @Ignore
//    var uniqueTech: List<String>,
    @SerializedName("team_bonus")
    @Expose
    var teamBonus: String,
//    @SerializedName("civilization_bonus")
//    @Expose
//    @Ignore
//    var civilizationBonus: List<String>

): Serializable