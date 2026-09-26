package com.example.mobileappdevelopmentvar2.data

import com.example.mobileappdevelopmentvar2.data.service.PostsApiService
import com.example.mobileappdevelopmentvar2.data.service.RecipesApiService
import com.example.mobileappdevelopmentvar2.data.service.TodoApiService
import com.example.mobileappdevelopmentvar2.data.service.UsersApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .proxy(proxy)
        .build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val recipesApiService: RecipesApiService by lazy {
        retrofitClient
            .create(RecipesApiService::class.java)
    }
    val usersApiService: UsersApiService by lazy {
        retrofitClient
            .create(UsersApiService::class.java)
    }

    val postsApiService: PostsApiService by lazy {
        retrofitClient
            .create(PostsApiService::class.java)
    }

    val todoApiService: TodoApiService by lazy {
        retrofitClient
            .create(TodoApiService::class.java)
    }
}