package com.example.afetprojesi.viewModels.debrisHelp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afetprojesi.dtos.responses.debrisHelp.DebrisHelpResponseDto
import com.example.afetprojesi.dtos.results.*
import com.example.afetprojesi.service.clients.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DebrisHelpListViewModel : ViewModel() {

    val data = MutableLiveData<DataResult<List<DebrisHelpResponseDto>>?>()


    fun getAllDebrisHelp(){
        val debrisHelpService = ApiUtils.getDebrisHelpService()

        debrisHelpService.getAllDebrisHelp().enqueue(object  :
            Callback<DataResult<List<DebrisHelpResponseDto>>> {
            override fun onFailure(
                call: Call<DataResult<List<DebrisHelpResponseDto>>>?,
                t: Throwable?
            ) {}

            override fun onResponse(
                call: Call<DataResult<List<DebrisHelpResponseDto>>>?,
                response: Response<DataResult<List<DebrisHelpResponseDto>>>?
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