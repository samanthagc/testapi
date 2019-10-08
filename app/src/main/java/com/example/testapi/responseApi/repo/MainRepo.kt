package com.example.testapi.responseApi.repo

import com.example.testapi.network.RetrofitInitializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepo {

    suspend fun getList() =
        withContext(Dispatchers.IO)  {
            RetrofitInitializer().responseService().list()
        }

}