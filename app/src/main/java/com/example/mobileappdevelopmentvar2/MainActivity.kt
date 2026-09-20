package com.example.mobileappdevelopmentvar2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobileappdevelopmentvar2.ui.theme.MobileAppDevelopmentVar2Theme
import com.example.mobileappdevelopmentvar2.viewModel.RecipeViewModel
import com.example.mobileappdevelopmentvar2.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileAppDevelopmentVar2Theme {
                val recipeViewModel: RecipeViewModel = viewModel()

                LaunchedEffect(Unit) {
                    recipeViewModel.fetchRecipe()
                }

                val userViewModel: UserViewModel = viewModel()

                LaunchedEffect(Unit) {
                    userViewModel.addUser(
                        firstName = "Ирина",
                        lastName = "Воронова",
                        age = 29,
                        hairColor = "Темные",
                        hairType = "Кудрявые"
                    ) { user ->
                        Log.d(
                            "UserLog",
                            "ID: ${user.id} | " +
                                    "Имя: ${user.firstName} | " +
                                    "Фамилия: ${user.lastName} | " +
                                    "Возраст: ${user.age} | " +
                                    "Волосы: ${user.hair.color}, ${user.hair.type}"
                        )
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileAppDevelopmentVar2Theme {
        Greeting("Android")
    }
}