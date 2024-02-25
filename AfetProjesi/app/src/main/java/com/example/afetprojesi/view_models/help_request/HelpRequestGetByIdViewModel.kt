package com.example.afetprojesi.view_models.help_request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.help_system.HelpRequestResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HelpRequestGetByIdViewModel : ViewModel() {
    val data = MutableLiveData<DataResult<HelpRequestResponseDto>?>()
    val error = MutableLiveData<Result?>()

    fun getByRequestTc(id : String){
        val requestService = ApiUtils.getRequestService()
        requestService.getByTc(id).enqueue(object : Callback<DataResult<HelpRequestResponseDto>> {
            override fun onFailure(call: Call<DataResult<HelpRequestResponseDto>>?, t: Throwable?) {}

            override fun onResponse(
                call: Call<DataResult<HelpRequestResponseDto>>?,
                response: Response<DataResult<HelpRequestResponseDto>>?
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