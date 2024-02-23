package com.example.afetprojesi.viewModels.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.request.RequestResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestListViewModel : ViewModel() {

    val data = MutableLiveData<DataResult<List<RequestResponseDto>>?>()


    fun getAllRequests(){
        val requestService = ApiUtils.getRequestService()

        requestService.getAllRequests().enqueue(object :
            Callback<DataResult<List<RequestResponseDto>>> {
            override fun onFailure(
                call: Call<DataResult<List<RequestResponseDto>>>?,
                t: Throwable?
            ) {}

            override fun onResponse(
                call: Call<DataResult<List<RequestResponseDto>>>?,
                response: Response<DataResult<List<RequestResponseDto>>>?
            ) {
                val result = response?.body()

                if (result != null){
                    data.value =result
                }
            }
        })
    }

    init {
        getAllRequests()
    }
}