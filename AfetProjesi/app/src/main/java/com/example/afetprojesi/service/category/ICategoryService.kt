package com.example.afetprojesi.service.category

import com.example.afetprojesi.dtos.responses.categories.CategoryResponseDto
import com.example.afetprojesi.dtos.results.DataResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ICategoryService {
    @GET("category/getall")
    fun getAllCategories() : Call<DataResult<List<CategoryResponseDto>>>

    @GET("category/getbyid/{id}")
    fun getCategoryById(@Path("id") id: Int) : Call<DataResult<CategoryResponseDto>>

}