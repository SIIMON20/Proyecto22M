package com.example.proyecto25febrero.navigation

sealed class AppScrens (val route: String) {

    object HomeScreen : AppScrens(route = "Pantalla de inicio")
    object LoginScreen : AppScrens(route = "Pantalla2")
}