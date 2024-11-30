package br.com.fiap.antifraude.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.Task
import br.com.fiap.antifraude.components.TaskGrid

@Composable
fun TaskGridScreen(navController: NavController) {
    val taskList = listOf(
        Task("Document", 5, 0.4f, "View") {},
        Task("Inbox &", 2, 0.7f, "Check") {},
        Task("Workflows", 9, 0.3f, "Review") {},
        Task("Critical", 5, 0.8f, "Fix") {}
    )

    TaskGrid(tasks = taskList)
}
