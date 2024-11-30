package br.com.fiap.antifraude.components

data class Task(
    val title: String,
    val newTasks: Int,
    val progress: Float,
    val buttonText: String,
    val onClick: () -> Unit
)
