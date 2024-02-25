package com.example.afetprojesi.view_models.category

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.categories.CategoryResponseDto
import com.example.afetprojesi.dtos.results.DataResult
import com.example.afetprojesi.service.clients.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryListViewModel: ViewModel() {
    var  data = MutableLiveData<DataResult<List<CategoryResponseDto>>?>()


    fun getAllCategories(){

        val categoryService = ApiUtils.getCategoryService()
        categoryService.getAllCategories().enqueue( object :
            Callback<DataResult<List<CategoryResponseDto>>> {
            override fun onFailure(call: Call<DataResult<List<CategoryResponseDto>>>?, t: Throwable?) {

            }

            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(
                call: Call<DataResult<List<CategoryResponseDto>>>?,
                response: Response<DataResult<List<CategoryResponseDto>>>?
            ) {

                val result = response?.body()
                if (result != null){
                    data.value = result

                    Log.wtf("kategoriess",result.message)
                }

                Log.wtf("hata_aldın_bebeyim",response?.errorBody().toString())


            }
        })

    }
    init {
        getAllCategories()
    }


}