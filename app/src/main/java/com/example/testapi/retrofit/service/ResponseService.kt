package com.example.testapi.retrofit.service

import com.example.testapi.model.ResponseAPI
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface ResponseService{

    @GET("posts")
    suspend fun list() : List<ResponseAPI>

}