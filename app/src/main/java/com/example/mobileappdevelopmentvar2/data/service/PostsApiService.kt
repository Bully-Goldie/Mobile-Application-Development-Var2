package com.example.mobileappdevelopmentvar2.data.service

import com.example.mobileappdevelopmentvar2.data.model.post.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface PostsApiService {
    @GET("posts/45")
    suspend fun getPost(): Post

    @PUT("posts/45")
    suspend fun updatePost(@Body post: Post): Post
}