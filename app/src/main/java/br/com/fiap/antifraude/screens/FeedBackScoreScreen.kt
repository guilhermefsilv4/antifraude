package br.com.fiap.antifraude.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlignVerticalBottom
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.ScoreCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FeedBackScoreScreen(
    generatedScore: MutableState<Int>,
    navController: NavController,
) {
    val score = generatedScore.value

    val message = when (score) {
        in 0..300 -> "Muito baixo"
        in 301..500 -> "Baixo"
        in 501..700 -> "Bom"
        in 701..1000 -> "Excelente"
        else -> "Pontuação inválida"
    }

    val icon = Icons.Default.AlignVerticalBottom

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Voltar") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ScoreCard(
                    navController,
                    score,
                    icon,
                    message
                )
            }
        }
    )
}