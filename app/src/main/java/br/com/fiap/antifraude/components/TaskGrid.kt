package br.com.fiap.antifraude.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskGrid(tasks: List<Task>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Categorias",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            items(tasks) { task ->
                TaskCard(task = task)
            }
        }
    }
}
