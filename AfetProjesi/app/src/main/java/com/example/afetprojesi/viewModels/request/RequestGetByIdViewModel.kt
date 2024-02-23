package com.example.afetprojesi.viewModels.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.request.RequestResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestGetByIdViewModel : ViewModel() {
    val data = MutableLiveData<DataResult<RequestResponseDto>?>()
    val error = MutableLiveData<Result?>()

    fun getByRequestTc(id : String){
        val requestService = ApiUtils.getRequestService()
        requestService.getByTc(id).enqueue(object : Callback<DataResult<RequestResponseDto>> {
            override fun onFailure(call: Call<DataResult<RequestResponseDto>>?, t: Throwable?) {}

            override fun onResponse(
                call: Call<DataResult<RequestResponseDto>>?,
                response: Response<DataResult<RequestResponseDto>>?
            ) {
                val result = response?.body()

                if (result != null){
                    data.value = result
                }

                else{
                    val errorBody = response?.errorBody()?.string()
                    val resultError = Gson().fromJson(errorBody, Result::class.java)

                    error.value = resultError
                }


            }
        })

    }



}