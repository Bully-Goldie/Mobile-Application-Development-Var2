package com.example.mobileappdevelopmentvar2.data.service

import com.example.mobileappdevelopmentvar2.data.model.product.ProductResponse
import retrofit2.http.GET

interface ProductsApiService {
    @GET("products")
    suspend fun getProduct(): ProductResponse
}