package com.example.mobileappdevelopmentvar2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    fun fetchRecipe() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getRecipes()

                for (recipe in response.recipes) {
                    Log.d(
                        "RetrofitLog",
                        "ID: ${recipe.id} | " +
                                "Название: ${recipe.name} | " +
                                "Время приготовления: ${recipe.cookTimeMinutes} | " +
                                "Трудность приготовления: ${recipe.difficulty}"
                    )
                }
            } catch (e: Exception) {
                Log.e("RetrofitError", "Ошибка при запросе: ${e.message}")
            }
        }
    }
}