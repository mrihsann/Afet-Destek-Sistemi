package com.example.afetprojesi.dtos.requests.request

data class RequestAddDto(
    var tc :String,
    var name : String,
    var surname : String,
    var birthDay : Int,
    var description : String,
    var phone : String,
    var city :String,
    var district : String,
    var neighbourhood : String,
    var street : String,
    var locationDescription: String,
    var status: Status,
    var categoryId : Int
)
