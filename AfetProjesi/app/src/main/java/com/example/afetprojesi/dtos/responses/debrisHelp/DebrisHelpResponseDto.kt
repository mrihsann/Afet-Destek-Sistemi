package com.example.afetprojesi.dtos.responses.debrisHelp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DebrisHelpResponseDto(
    @Expose
    @SerializedName("id")
    var  id : Int,

    @Expose
    @SerializedName("name")
    var name:String,

    @Expose
    @SerializedName("surname")
    var surname : String,

    @Expose
    @SerializedName("city")
    var city : String,

    @Expose
    @SerializedName("district")
    var district : String,

    @Expose
    @SerializedName("numberOfTeam")
    var numberOfTeam : String,

    @Expose
    @SerializedName("equipment")
    var equipment : String,

    @Expose
    @SerializedName("description")
    var description : String
)