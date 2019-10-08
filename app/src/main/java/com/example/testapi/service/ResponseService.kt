package com.example.testapi.service

import com.example.testapi.responseApi.model.ResponseAPI
import retrofit2.http.GET

interface ResponseService{

    @GET("posts")
    suspend fun list() : List<ResponseAPI>

}