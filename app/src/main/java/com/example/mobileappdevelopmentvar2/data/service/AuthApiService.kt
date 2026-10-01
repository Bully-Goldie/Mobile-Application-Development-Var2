package com.example.mobileappdevelopmentvar2.data.service

import com.example.mobileappdevelopmentvar2.data.model.auth.Auth
import com.example.mobileappdevelopmentvar2.data.model.user.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApiService {
    @GET("user/me")
    suspend fun getUser(@Header("Authorization") auth: String)

    @POST("auth/login")
    suspend fun logoutUser(@Body loginRequest: Auth): User
}