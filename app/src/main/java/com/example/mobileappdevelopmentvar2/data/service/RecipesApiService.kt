package com.example.mobileappdevelopmentvar2.data.service

import com.example.mobileappdevelopmentvar2.data.model.recipe.RecipeResponse
import retrofit2.http.GET

interface RecipesApiService {
    @GET("recipes")
    suspend fun getRecipes(): RecipeResponse
}