package com.example.testapi.retrofit.service

import com.example.testapi.model.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET

interface ResponseService{

    @GET("posts")
    fun list() : Call<List<ResponseAPI>>

}