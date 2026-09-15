package com.example.mobileappdevelopmentvar2

import com.example.mobileappdevelopmentvar2.Model.RecipeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse
}