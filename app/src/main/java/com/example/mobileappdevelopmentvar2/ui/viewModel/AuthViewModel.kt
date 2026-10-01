package com.example.mobileappdevelopmentvar2.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.data.RetrofitClient
import com.example.mobileappdevelopmentvar2.data.model.auth.Auth
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
    fun login(auth: Auth) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.authViewModel.logoutUser(auth)

                Log.d("LoginViewModel", "User: ${authUser.firstName} ${authUser.lastName}")

                val currentUser = RetrofitClient.authViewModel.getUser("Bearer ${authUser.accessToken}")

                Log.d("LoginViewModel", "${authUser.firstName}")

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}