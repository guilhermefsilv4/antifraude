package br.com.fiap.antifraude.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.Loading
import br.com.fiap.antifraude.components.Scanning
import kotlinx.coroutines.delay

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
        isSuccess = true
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
        else -> FailureScreen(navController)
    }
}
