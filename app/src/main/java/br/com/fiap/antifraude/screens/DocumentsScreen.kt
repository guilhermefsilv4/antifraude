package br.com.fiap.antifraude.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.Loading
import br.com.fiap.antifraude.components.Scanning
import kotlinx.coroutines.delay

@Composable
fun DocumentsScreen(navController: NavController) {
    var isSuccess by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var isScanning by remember { mutableStateOf(true) }
    var onRetry by remember { mutableStateOf(false) }

    val message = "Validando seus documentos, por favor, aguarde..."

    LaunchedEffect(Unit) {
        delay(2000)
        isScanning = false
        isLoading = true
        delay(2000)
        isSuccess = onRetry
        isLoading = false
    }

    when {
        isScanning -> Scanning(
            mensagem = message,
            imageVector = Icons.Default.DocumentScanner,
            contentDescription = "Documentos"
        )

        isLoading -> Loading()
        isSuccess -> SuccessScreen(navController)
        else -> FailureScreen(
            navController,
            message = "Documentos inválidos",
            icon = Icons.Default.Error,
            description = "Documentos",
            onRetry = {
                navController.navigate("documents")
            }
        )
    }
}
