package com.example.afetprojesi.viewModels.debrisHelp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.debrisHelp.DebrisHelpResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DebrisHelpGetByIdViewModel : ViewModel() {

    val data = MutableLiveData<DataResult<DebrisHelpResponseDto>?>()
    val error = MutableLiveData<Result?>()

    fun getDebrisHelpById(id : Int) {
        val debrisHelpService = ApiUtils.getDebrisHelpService()
        debrisHelpService.getById(id).enqueue(object : Callback<DataResult<DebrisHelpResponseDto>> {
            override fun onFailure(call: Call<DataResult<DebrisHelpResponseDto>>?, t: Throwable?) {
            }

            override fun onResponse(
                call: Call<DataResult<DebrisHelpResponseDto>>?,
                response: Response<DataResult<DebrisHelpResponseDto>>?
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