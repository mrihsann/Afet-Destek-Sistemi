package com.example.afetprojesi.dtos.requests.help_system

import com.example.afetprojesi.dtos.enum_class.Status

data class HelpRequestDto(
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
