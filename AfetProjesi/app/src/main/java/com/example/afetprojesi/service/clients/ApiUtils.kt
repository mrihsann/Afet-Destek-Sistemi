package com.example.afetprojesi.service.clients

import com.example.afetprojesi.service.category.ICategoryService
import com.example.afetprojesi.service.debrisHelp.IDebrisHelpService
import com.example.afetprojesi.service.request.IRequestService

class ApiUtils {
    companion object{
        val BASE_URL = "http://10.0.2.2:8080/api/"


        fun getCategoryService() : ICategoryService{
            return RetrofitClient.getClient(BASE_URL).create(ICategoryService::class.java)
        }
        fun getRequestService() : IRequestService{
            return RetrofitClient.getClient(BASE_URL).create(IRequestService::class.java)
        }

        fun getDebrisHelpService(): IDebrisHelpService {
            return RetrofitClient.getClient(BASE_URL).create(IDebrisHelpService::class.java)
        }

        /*        fun getReportingDebrisService() : IReportingDebrisService{
                    return RetrofitClient.getClient(BASE_URL).create(IReportingDebrisService::class.java)
                }*/
    }
}