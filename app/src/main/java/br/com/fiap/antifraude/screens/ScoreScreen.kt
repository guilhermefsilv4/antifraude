package br.com.fiap.antifraude.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Score
import androidx.compose.runtime.*
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.Loading
import br.com.fiap.antifraude.components.Scanning
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun ScoreScreen(navController: NavController) {
    val score = remember { mutableIntStateOf(Random.nextInt(0, 1001)) }
    var isSuccess by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var isScanning by remember { mutableStateOf(true) }

    val message = "Validando seu score..."

    LaunchedEffect(Unit) {
        delay(2000)
        isScanning = false
        isLoading = true
        delay(2000)
        isSuccess = true
        isLoading = false
    }

    when {
        isScanning -> Scanning(
            mensagem = message,
            imageVector = Icons.Default.Score,
            contentDescription = "Score"
        )

        isLoading -> Loading()
        else -> FeedBackScoreScreen(score, navController)
    }
}
