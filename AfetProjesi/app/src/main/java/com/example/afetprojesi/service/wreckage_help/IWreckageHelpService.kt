package com.example.afetprojesi.service.wreckage_help

import com.example.afetprojesi.dtos.requests.wreckage_help.WreckageHelpDto
import com.example.afetprojesi.dtos.responses.wreckage_help.WreckageHelpResponseDto
import com.example.afetprojesi.dtos.results.DataResult
import com.example.afetprojesi.dtos.results.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface IWreckageHelpService {


    @POST("debrishelp/add")
    fun addDebrisHelp(@Body dto : WreckageHelpDto): Call<Result>

    @GET("debrishelp/getall")
    fun getAllDebrisHelp() : Call<DataResult<List<WreckageHelpResponseDto>>>

    @GET("debrishelp/get/{id}")
    fun getById(@Path("id") id : Int): Call<DataResult<WreckageHelpResponseDto>>

    @POST("debrishelp/delete/{id}")
    fun deleteById(@Path("id") id : Int) : Call<Result>
}