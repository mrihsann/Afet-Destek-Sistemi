package com.example.afetprojesi.dtos.results

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataResult<T>(
    @Expose
    @SerializedName("data")
    var data : T?,
    @Expose
    @SerializedName("message")
    var message :String,

    @Expose
    @SerializedName("success")
    var success : Boolean
)

