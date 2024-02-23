package com.example.afetprojesi.dtos.responses.reportingDebris

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ReportingDebrisResponseDto(
    @Expose
    @SerializedName("id")
    var id:Int,

    @Expose
    @SerializedName("phoneNumber")
    var phoneNumber: String,

    @Expose
    @SerializedName("imageUrl")
    var imageUrl : String,

    @Expose
    @SerializedName("city")
    var city:String,

    @Expose
    @SerializedName("district")
    var district : String,
    @Expose
    @SerializedName("neighbourhood")
    var neighbourhood:String,

    @Expose
    @SerializedName("street")
    var street : String,

    @Expose
    @SerializedName("locationDescription")
    var locationDescription : String,

    @Expose
    @SerializedName("ekipVarmı")
    var ekipVarmi :String
)
