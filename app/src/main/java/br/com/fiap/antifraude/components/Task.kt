package br.com.fiap.antifraude.components

import androidx.compose.ui.graphics.vector.ImageVector

data class Task(
    val title: String,
    val imageVector: ImageVector,
    val newTasks: Int,
    val progress: Float,
    val buttonText: String,
    val onClick: () -> Unit
)
