package com.example.mobileappdevelopmentvar2.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.data.RetrofitClient
import com.example.mobileappdevelopmentvar2.data.model.post.Post
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    fun getPost() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.postsApiService.getPost()

                Log.d("PostLog(ДО)", "ID: ${response.id} | " +
                        "Название: ${response.title} | " +
                        "Текст: ${response.body} | " +
                        "Тэги: ${response.tags} | " +
                        "Количество просмотров: ${response.views}")
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
    fun updatePost(post: Post) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.postsApiService.updatePost(post)

                Log.d("PostLog(ПОСЛЕ)", "ID: ${response.id} | " +
                        "Название: ${response.title} | " +
                        "Текст: ${response.body} | " +
                        "Тэги: ${response.tags} | " +
                        "Количество просмотров: ${response.views}")
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}