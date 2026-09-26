package com.example.mobileappdevelopmentvar2.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.data.RetrofitClient
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    fun fetchTodo() {
        viewModelScope.launch {
            val  id = 27

            try {
                val response = RetrofitClient.todoApiService.deleteTodo(id = id)

                Log.d(
                    "TodoLog",
                    "ID: ${response.id} | " +
                            "Задание: ${response.todo} | " +
                            "Завершенный: ${response.completed} | " +
                            "UserID: ${response.userId} | " +
                            "Удалено: ${response.isDeleted} | " +
                            "Время удаления: ${response.deletedOn} | "
                )
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}