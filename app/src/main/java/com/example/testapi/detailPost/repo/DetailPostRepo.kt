package com.example.testapi.detailPost.repo

import com.example.testapi.network.RetrofitInitializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailPostRepo {

    suspend fun getItemSelected(idItem : Int) =
        withContext(Dispatchers.IO){
            RetrofitInitializer().postService().responseById(idItem)
        }

}

