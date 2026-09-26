package com.example.mobileappdevelopmentvar2.data.service

import com.example.mobileappdevelopmentvar2.data.model.todo.Todo
import retrofit2.http.DELETE
import retrofit2.http.Path

interface TodoApiService {
    @DELETE("todos/{id}")
    suspend fun deleteTodo(@Path("id") id: Int): Todo
}