package com.example.afetprojesi.presentation.view_models.wreckage_system

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.wreckage_help.WreckageHelpResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WreckageHelpListViewModel : ViewModel() {

    val data = MutableLiveData<DataResult<List<WreckageHelpResponseDto>>?>()


    fun getAllDebrisHelp(){
        val debrisHelpService = ApiUtils.getDebrisHelpService()

        debrisHelpService.getAllDebrisHelp().enqueue(object  :
            Callback<DataResult<List<WreckageHelpResponseDto>>> {
            override fun onFailure(
                call: Call<DataResult<List<WreckageHelpResponseDto>>>?,
                t: Throwable?
            ) {}

            override fun onResponse(
                call: Call<DataResult<List<WreckageHelpResponseDto>>>?,
                response: Response<DataResult<List<WreckageHelpResponseDto>>>?
            ) {
                val result = response?.body()

                if (result != null){
                    data.value = result
                }
            }
        })

    }

    init {
        getAllDebrisHelp()
    }


}