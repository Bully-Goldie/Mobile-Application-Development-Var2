package com.example.mobileappdevelopmentvar2.data.model.todo

data class Todo(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int,
    val isDeleted: Boolean,
    val deletedOn: String
)