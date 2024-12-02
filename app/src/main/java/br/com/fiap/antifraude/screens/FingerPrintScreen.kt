package br.com.fiap.antifraude.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.runtime.*
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.Loading
import br.com.fiap.antifraude.components.Scanning
import kotlinx.coroutines.delay

@Composable
fun FingerPrintScreen(navController: NavController) {
    var isSuccess by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var isScanning by remember { mutableStateOf(true) }

    val message = "Coloque o dedo no leitor"

    LaunchedEffect(Unit) {
        delay(2000)
        isScanning = false
        isLoading = true
        delay(2000)
        isSuccess = false
        isLoading = false
    }

    when {
        isScanning -> Scanning(
            mensagem = message,
            imageVector = Icons.Default.Fingerprint,
            contentDescription = "Fingerprint"
        )

        isLoading -> Loading()
        isSuccess -> SuccessScreen(navController)
        else -> FailureScreen(
            navController,
            message = "Digital inválida!",
            icon = Icons.Default.Error,
            description = "Fingerprint",
            onRetry = {
                navController.navigate("fingerprint")
            }
        )
    }
}
