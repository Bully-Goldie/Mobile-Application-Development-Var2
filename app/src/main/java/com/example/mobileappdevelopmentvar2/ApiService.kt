package com.example.mobileappdevelopmentvar2

import com.example.mobileappdevelopmentvar2.Model.RecipeResponse
import com.example.mobileappdevelopmentvar2.Model.User
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse

    @POST("users/add")
    suspend fun createUser(@Body user: User): User
}