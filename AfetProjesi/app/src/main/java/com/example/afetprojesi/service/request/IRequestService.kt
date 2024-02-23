package com.example.afetprojesi.service.request

import com.example.afetprojesi.dtos.requests.request.RequestAddDto
import com.example.afetprojesi.dtos.responses.request.RequestResponseDto
import com.example.afetprojesi.dtos.results.DataResult

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import com.example.afetprojesi.dtos.results.Result

interface IRequestService {

    @GET("requests/getall")
    fun getAllRequests(): Call<DataResult<List<RequestResponseDto>>>

    @POST("requests/add")
    fun addRequest(@Body dto : RequestAddDto) : Call<Result>

    @PUT("requests/update")
    fun  updateRequest(@Body dto :RequestAddDto): Call<Result>

    @DELETE("requests/delete/{tc}")
    fun delete(@Path("tc") tc : String): Call<Result>

    @GET("requests/get/{tc}")
    fun getByTc(@Path("tc") tc : String) : Call<DataResult<RequestResponseDto>>

    @GET("requests/getdetails/{id}")
    fun  getDetailsByCategoryId(@Path("id") id : Int) : Call<DataResult<List<RequestResponseDto>>>

}