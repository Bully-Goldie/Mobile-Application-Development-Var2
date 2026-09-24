package com.example.mobileappdevelopmentvar2.data.model.post

data class Post(
    val id: Int? = null,
    val title: String,
    val body: String,
    val tags: List<String>,
    val views: Int
)
