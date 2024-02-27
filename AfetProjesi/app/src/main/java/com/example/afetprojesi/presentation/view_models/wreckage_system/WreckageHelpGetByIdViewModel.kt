package com.example.afetprojesi.presentation.view_models.wreckage_system

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.wreckage_help.WreckageHelpResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WreckageHelpGetByIdViewModel : ViewModel() {

    val data = MutableLiveData<DataResult<WreckageHelpResponseDto>?>()
    val error = MutableLiveData<Result?>()

    fun getDebrisHelpById(id : Int) {
        val debrisHelpService = ApiUtils.getDebrisHelpService()
        debrisHelpService.getById(id).enqueue(object : Callback<DataResult<WreckageHelpResponseDto>> {
            override fun onFailure(call: Call<DataResult<WreckageHelpResponseDto>>?, t: Throwable?) {
            }

            override fun onResponse(
                call: Call<DataResult<WreckageHelpResponseDto>>?,
                response: Response<DataResult<WreckageHelpResponseDto>>?
            ) {

                val result = response?.body()

                if (result != null){
                    data.value = result
                }

                else{
                    val errorBody = response?.errorBody()?.string()
                    val resultError = Gson().fromJson(errorBody, Result::class.java)
                    error.value=resultError
                }

            }
        })
    }




}