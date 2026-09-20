package com.example.mobileappdevelopmentvar2.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappdevelopmentvar2.Model.User
import com.example.mobileappdevelopmentvar2.Model.UserHair
import com.example.mobileappdevelopmentvar2.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun addUser(
        firstName: String,
        lastName: String,
        age: Int,
        hairColor: String,
        hairType: String,
        onResult: (User) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val user = User(
                    firstName = firstName,
                    lastName = lastName,
                    age = age,
                    hair = UserHair(
                        color = hairColor,
                        type = hairType
                    )
                )

                val response = RetrofitClient.apiService.createUser(user)

                onResult(response)

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}