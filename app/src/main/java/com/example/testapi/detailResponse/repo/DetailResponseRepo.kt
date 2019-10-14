package com.example.testapi.detailResponse.repo

import com.example.testapi.network.RetrofitInitializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailResponseRepo {

    suspend fun getItemSelected(idItem : Int) =
        withContext(Dispatchers.IO){
            RetrofitInitializer().responseService().responseById(idItem)
        }

}

