package com.example.testapi.post.repo

import com.example.testapi.network.RetrofitInitializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepo {

    suspend fun getList() =
        withContext(Dispatchers.IO)  {
            RetrofitInitializer().postService().list()
        }

}