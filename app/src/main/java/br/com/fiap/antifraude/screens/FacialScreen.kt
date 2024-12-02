package br.com.fiap.antifraude.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FaceRetouchingOff
import androidx.compose.runtime.*
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.Loading
import br.com.fiap.antifraude.components.Scanning
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun FacialScreen(navController: NavController) {
    var isSuccess by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var isScanning by remember { mutableStateOf(true) }

    val message = "Capturando face..."

    LaunchedEffect(Unit) {
        delay(2000)
        isScanning = false
        isLoading = true
        delay(2000)
        isSuccess = Random.nextBoolean()
        isLoading = false
    }

    when {
        isScanning -> Scanning(
            mensagem = message,
            imageVector = Icons.Default.Face,
            contentDescription = "Facial"
        )

        isLoading -> Loading()
        isSuccess -> SuccessScreen(navController)
        else -> FailureScreen(
            navController,
            message = "Erro ao capturar facial",
            icon = Icons.Default.FaceRetouchingOff,
            description = "Facial",
            onRetry = { navController.navigate("facial") }
        )
    }
}
