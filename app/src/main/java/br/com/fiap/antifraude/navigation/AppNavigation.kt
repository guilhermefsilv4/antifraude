package br.com.fiap.antifraude.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.antifraude.screens.TaskGridScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "taskGrid"
    ) {
        composable("taskGrid") {
            TaskGridScreen(navController = navController)
        }
    }
}