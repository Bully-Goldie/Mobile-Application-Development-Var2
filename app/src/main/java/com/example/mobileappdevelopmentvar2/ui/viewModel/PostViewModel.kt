package com.example.mobileappdevelopmentvar2.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.data.RetrofitClient
import com.example.mobileappdevelopmentvar2.data.model.post.Post
import com.example.mobileappdevelopmentvar2.data.service.PostsApiService
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    fun updatePost() {
        viewModelScope.launch {
            try {
                val id = 45

                val postBefore = RetrofitClient.postsApiService.getPost(id)

                Log.d("RetrofitSuccess", "ID: ${postBefore.id}")
                Log.d("RetrofitSuccess", "Название: ${postBefore.title}")
                Log.d("RetrofitSuccess", "Текст: ${postBefore.body}")
                Log.d(
                    "RetrofitSuccess",
                    "Теги: ${postBefore.tags.joinToString(", ")}"
                )
                Log.d("RetrofitSuccess", "Просмотры: ${postBefore.views}")

                val post = postBefore.copy(
                    title = "Уют в каждой детали: встречайте нашу новинку!",
                    body = "Мы знаем, как важно возвращаться туда, где тепло и спокойно. Наша новая коллекция ароматических свечей из соевого воска создана именно для таких моментов.",
                    tags = listOf("декор дома", "уют в доме", "аромасвечи", "подарок девушке", "ручная работа", "новинка"),
                    views = 0
                )

                val postAfter =
                    RetrofitClient.postsApiService.updatePost(id, post)

                Log.d("RetrofitSuccess", "ID: ${postAfter.id}")
                Log.d("RetrofitSuccess", "Название: ${postAfter.title}")
                Log.d("RetrofitSuccess", "Текст: ${postAfter.body}")
                Log.d(
                    "RetrofitSuccess",
                    "Теги: ${postAfter.tags.joinToString(", ")}"
                )
                Log.d("RetrofitSuccess", "Просмотры: ${postAfter.views}")

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}