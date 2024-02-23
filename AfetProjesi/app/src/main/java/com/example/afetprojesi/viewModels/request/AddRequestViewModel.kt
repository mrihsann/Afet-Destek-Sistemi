package com.example.afetprojesi.viewModels.request

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.requests.request.RequestAddDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddRequestViewModel : ViewModel() {

    val data = MutableLiveData<Result?>()

    val error = MutableLiveData<ValidationExceptionResult>()


    fun addRequest(dto : RequestAddDto){

        val requestService = ApiUtils.getRequestService()
        requestService.addRequest(dto).enqueue(object  : Callback<Result> {
            override fun onFailure(call: Call<Result>?, t: Throwable?) {
                Log.wtf("request_error",t?.message.toString())
            }

            override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                val result = response?.body()
                if (result!=null){
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