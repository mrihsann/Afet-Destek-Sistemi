package com.example.afetprojesi.dtos.requests.wreckage_help

data class WreckageHelpDto(
    var name:String,
    var surname : String,
    var city : String,
    var district : String,
    var numberOfTeam : String,
    var equipment : String,
    var description : String,
    var reportingDebrisId:Int
)
