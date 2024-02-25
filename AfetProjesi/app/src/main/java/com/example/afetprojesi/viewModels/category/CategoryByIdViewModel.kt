package com.example.afetprojesi.viewModels.category

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.categories.CategoryResponseDto
import com.example.afetprojesi.dtos.results.DataResult
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.afetprojesi.dtos.results.Result
import com.example.afetprojesi.service.clients.ApiUtils

class CategoryByIdViewModel : ViewModel() {

    val data = MutableLiveData<DataResult<CategoryResponseDto>>()

    val error = MutableLiveData<Result?>()


    fun getById(id : Int){


        val categoryService = ApiUtils.getCategoryService()
        categoryService.getCategoryById(id).enqueue(object  :
            Callback<DataResult<CategoryResponseDto>> {
            override fun onFailure(call: Call<DataResult<CategoryResponseDto>>?, t: Throwable?) {
                Log.e("server_hata",t?.message.toString())

            }

            override fun onResponse(
                call: Call<DataResult<CategoryResponseDto>>?,
                response: Response<DataResult<CategoryResponseDto>>?
            ) {
                val result = response?.body()
                if (result !=null){
                    data.value = response.body()
                    Log.e("id_kat",response.body().toString())

                }else{
                    val errorBody = response?.errorBody()?.string()
                    val resultError = Gson().fromJson(errorBody, Result::class.java)
                    error.value = resultError

                    Log.d("hata_aldın",resultError.toString())

                }

            }

        })
    }



}