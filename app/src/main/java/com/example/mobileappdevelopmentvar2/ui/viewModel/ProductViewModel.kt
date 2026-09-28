package com.example.mobileappdevelopmentvar2.ui.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.data.RetrofitClient
import com.example.mobileappdevelopmentvar2.data.model.product.Product
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    var productsState by mutableStateOf<List<Product>>(emptyList())
        private set
    fun fetchProduct() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.productViewModel.getProduct()

                productsState = response.products
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}