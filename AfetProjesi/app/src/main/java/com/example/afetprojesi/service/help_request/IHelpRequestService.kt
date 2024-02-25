package com.example.afetprojesi.service.help_request

import com.example.afetprojesi.dtos.requests.help_system.HelpRequestDto
import com.example.afetprojesi.dtos.responses.help_system.HelpRequestResponseDto
import com.example.afetprojesi.dtos.results.DataResult

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import com.example.afetprojesi.dtos.results.Result

interface IHelpRequestService {

    @GET("requests/getall")
    fun getAllRequests(): Call<DataResult<List<HelpRequestResponseDto>>>

    @POST("requests/add")
    fun addRequest(@Body dto : HelpRequestDto) : Call<Result>

    @PUT("requests/update")
    fun  updateRequest(@Body dto :HelpRequestDto): Call<Result>

    @DELETE("requests/delete/{tc}")
    fun delete(@Path("tc") tc : String): Call<Result>

    @GET("requests/get/{tc}")
    fun getByTc(@Path("tc") tc : String) : Call<DataResult<HelpRequestResponseDto>>

    @GET("requests/getdetails/{id}")
    fun  getDetailsByCategoryId(@Path("id") id : Int) : Call<DataResult<List<HelpRequestResponseDto>>>

}