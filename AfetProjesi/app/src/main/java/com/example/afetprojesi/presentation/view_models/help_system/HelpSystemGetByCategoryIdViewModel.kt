package com.example.afetprojesi.presentation.view_models.help_system

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.help_system.HelpRequestResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HelpSystemGetByCategoryIdViewModel : ViewModel() {

    val data = MutableLiveData<DataResult<List<HelpRequestResponseDto>>?>()


    fun getRequestByCategoryId(id : Int){
        val requestService = ApiUtils.getRequestService()
        requestService.getDetailsByCategoryId(id).enqueue(object :
            Callback<DataResult<List<HelpRequestResponseDto>>> {
            override fun onFailure(
                call: Call<DataResult<List<HelpRequestResponseDto>>>?,
                t: Throwable?
            ) {}

            override fun onResponse(
                call: Call<DataResult<List<HelpRequestResponseDto>>>?,
                response: Response<DataResult<List<HelpRequestResponseDto>>>?
            ) {
                val result = response?.body()
                if (result != null){
                    data.value = result
                }

            }
        })

    }


}