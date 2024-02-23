package com.example.afetprojesi.service.debrisHelp

import com.example.afetprojesi.dtos.requests.debrisHelp.DebrisHelpDto
import com.example.afetprojesi.dtos.responses.debrisHelp.DebrisHelpResponseDto
import com.example.afetprojesi.dtos.results.DataResult
import com.example.afetprojesi.dtos.results.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface IDebrisHelpService {


    @POST("debrishelp/add")
    fun addDebrisHelp(@Body dto : DebrisHelpDto): Call<Result>

    @GET("debrishelp/getall")
    fun getAllDebrisHelp() : Call<DataResult<List<DebrisHelpResponseDto>>>

    @GET("debrishelp/get/{id}")
    fun getById(@Path("id") id : Int): Call<DataResult<DebrisHelpResponseDto>>

    @POST("debrishelp/delete/{id}")
    fun deleteById(@Path("id") id : Int) : Call<Result>
}