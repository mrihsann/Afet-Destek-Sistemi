package com.example.afetprojesi.dtos.results

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @Expose
    @SerializedName("success")
    var success: Boolean,

    @Expose
    @SerializedName("message")
    var message : String
)