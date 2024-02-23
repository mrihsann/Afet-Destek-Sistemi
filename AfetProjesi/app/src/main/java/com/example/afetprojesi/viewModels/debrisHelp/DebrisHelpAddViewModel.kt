package com.example.afetprojesi.viewModels.debrisHelp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.requests.debrisHelp.DebrisHelpDto
import com.example.afetprojesi.dtos.results.ValidationExceptionResult
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.afetprojesi.dtos.results.Result
import com.example.afetprojesi.service.clients.ApiUtils

class DebrisHelpAddViewModel  : ViewModel(){

    val data = MutableLiveData<Result?>()

    val error = MutableLiveData<ValidationExceptionResult>();


    fun addDebrisHelp(dto : DebrisHelpDto){

        val debrisHelpService = ApiUtils.getDebrisHelpService()
        debrisHelpService.addDebrisHelp(dto).enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>?, t: Throwable?) {}

            override fun onResponse(call: Call<Result>?, response: Response<Result>?) {

                val result = response?.body()
                if (result != null){
                    data.value = result
                }
                else{
                    val errorBody = response?.errorBody()?.string()
                    val resultError = Gson().fromJson(errorBody, ValidationExceptionResult::class.java)
                    error.value = resultError
                }



            }
        })

    }



}
