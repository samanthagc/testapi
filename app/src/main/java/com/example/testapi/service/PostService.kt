package com.example.testapi.service

import com.example.testapi.post.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("posts")
    suspend fun list(): List<Post>

    @GET("posts/{responseId}")
    suspend fun responseById(@Path("responseId") responseId: Int): Post

}