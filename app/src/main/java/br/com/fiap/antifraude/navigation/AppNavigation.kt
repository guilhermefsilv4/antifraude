package br.com.fiap.antifraude.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.antifraude.screens.DocumentsScreen
import br.com.fiap.antifraude.screens.FacialScreen
import br.com.fiap.antifraude.screens.FingerPrintScreen
import br.com.fiap.antifraude.screens.HomeScreen
import br.com.fiap.antifraude.screens.ScoreScreen
import br.com.fiap.antifraude.screens.TaskGridScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("taskGrid") {
            TaskGridScreen(navController)
        }
        composable("fingerprint") {
            FingerPrintScreen(navController)
        }
        composable("facial") {
            FacialScreen(navController)
        }
        composable("documents") {
            DocumentsScreen(navController)
        }
        composable("score") {
            ScoreScreen(navController)
        }
    }
}