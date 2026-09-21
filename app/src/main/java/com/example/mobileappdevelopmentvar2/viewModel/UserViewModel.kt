package com.example.mobileappdevelopmentvar2.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.Model.User
import com.example.mobileappdevelopmentvar2.Model.UserHair
import com.example.mobileappdevelopmentvar2.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun addUser(user: User) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.createUser(user)

                Log.d(
                    "UserLog",
                    "ID: ${response.id} | " +
                            "Имя: ${response.firstName} | " +
                            "Фамилия: ${response.lastName} | " +
                            "Возраст: ${response.age} | " +
                            "Волосы: ${response.hair.color}, ${response.hair.type}"
                )

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}