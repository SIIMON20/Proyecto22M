package com.example.proyecto25febrero.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto25febrero.Screens.HomeScreen
import com.example.proyecto25febrero.Screens.LoginScreen

@Composable

fun AppNavigation(
    isLoading: Boolean,
    enviar: Boolean,
    onClick: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScrens.LoginScreen.route
    ){
        composable(route = AppScrens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScrens.LoginScreen.route){
            if(enviar){
                LaunchedEffect(key1 = Unit){
                    navController.navigate(AppScrens.HomeScreen.route){
                        popUpTo(AppScrens.LoginScreen.route){
                            inclusive = true
                        }
                    }
                }
            }else{
                LoginScreen(
                    navController,
                    isLoading = false,
                    onLoginClick = onClick
                )
            }
        }
    }
}