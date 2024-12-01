package br.com.fiap.antifraude.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Score
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.Task
import br.com.fiap.antifraude.components.TaskGrid

@Composable
fun TaskGridScreen(navController: NavController) {
    val taskList = listOf(
        Task("Digital", Icons.Default.Fingerprint, 1, 0.4f, "Coletar") {
            navController.navigate("fingerprint")
        },
        Task("Facial", Icons.Default.Face, 2, 0.7f, "Coletar") {
            navController.navigate("facial")
        },
        Task("Documentos", Icons.Default.DocumentScanner, 9, 0.3f, "Enviar") {
            navController.navigate("documents")
        },
        Task("Score", Icons.Default.Score, 5, 0.8f, "Ver") {
            navController.navigate("score")
        }
    )

    TaskGrid(tasks = taskList)
}
