package com.example.mobileappdevelopmentvar2.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.data.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun fetchProduct() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.productViewModel.fetchProduct()


            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}