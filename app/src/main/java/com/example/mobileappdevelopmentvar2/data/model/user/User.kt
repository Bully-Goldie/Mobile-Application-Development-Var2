package com.example.mobileappdevelopmentvar2.data.model.user

data class User(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val hair: UserHair
)