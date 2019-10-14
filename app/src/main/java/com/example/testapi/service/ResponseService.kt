package com.example.testapi.service

import com.example.testapi.responseApi.model.ResponseAPI
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface ResponseService {

    @GET("posts")
    suspend fun list(): List<ResponseAPI>

    @GET("posts/{responseId}")
    suspend fun responseById(@Path("responseId") responseId: Int): ResponseAPI

}