package com.example.afetprojesi.dtos.responses.categories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryResponseDto(
    @Expose
    @SerializedName("name")
    var name : String,
    @Expose
    @SerializedName("description")
    var description : String
)