package com.example.afetprojesi.service.clients

import com.example.afetprojesi.service.category.ICategoryService
import com.example.afetprojesi.service.wreckage_help.IWreckageHelpService
import com.example.afetprojesi.service.help_request.IHelpRequestService

class ApiUtils {
    companion object{
        val BASE_URL = "http://10.0.2.2:8080/api/"


        fun getCategoryService() : ICategoryService{
            return RetrofitClient.getClient(BASE_URL).create(ICategoryService::class.java)
        }
        fun getRequestService() : IHelpRequestService{
            return RetrofitClient.getClient(BASE_URL).create(IHelpRequestService::class.java)
        }

        fun getDebrisHelpService(): IWreckageHelpService {
            return RetrofitClient.getClient(BASE_URL).create(IWreckageHelpService::class.java)
        }

        /*        fun getReportingDebrisService() : IReportingDebrisService{
                    return RetrofitClient.getClient(BASE_URL).create(IReportingDebrisService::class.java)
                }*/
    }
}