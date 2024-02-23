package com.example.afetprojesi.dtos.responses.request

import com.example.afetprojesi.dtos.requests.request.Status
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestResponseDto(
    @Expose
    @SerializedName("tc")
    var tc : String,

    @Expose
    @SerializedName("name")
    var name : String,

    @Expose
    @SerializedName("surname")
    var surname : String,

    @Expose
    @SerializedName("birthDay")
    var birthDay : Int,

    @Expose
    @SerializedName("description")
    var description : String,

    @Expose
    @SerializedName("phone")
    var phone : String,

    @Expose
    @SerializedName("city")
    var city : String,

    @Expose
    @SerializedName("district")
    var district : String,

    @Expose
    @SerializedName("neighbourhood")
    var neighbourhood : String,

    @Expose
    @SerializedName("street")
    var street : String,

    @Expose
    @SerializedName("locationDescription")
    var locationDescription : String,
    @Expose
    @SerializedName("status")
    var status: Status,

    @Expose
    @SerializedName("categoryName")
    var categoryName : String

)
