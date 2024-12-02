package br.com.fiap.antifraude.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SimCard
import androidx.compose.material.icons.filled.SimCardAlert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.CustomButton
import br.com.fiap.antifraude.components.Loading
import br.com.fiap.antifraude.components.forms.Phone
import br.com.fiap.antifraude.components.Scanning
import br.com.fiap.antifraude.components.layout.ReturnTopBar
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SIMSwapScreen(navController: NavController) {
    var isSuccess by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var isScanning by remember { mutableStateOf(false) }
    var phoneNumber by remember { mutableStateOf("") }
    var validateRequested by remember { mutableStateOf(false) }
    var isFormVisible by remember { mutableStateOf(true) }

    LaunchedEffect(validateRequested) {
        if (validateRequested) {
            isFormVisible = false
            isScanning = true
            delay(2000)
            isScanning = false
            isLoading = true
            delay(2000)
            isSuccess = validatePhoneNumber(phoneNumber)
            isLoading = false
        }
    }

    when {
        isScanning -> Scanning(
            mensagem = "Validando troca de SIM...",
            imageVector = Icons.Default.SimCard,
            contentDescription = "SIM Swap"
        )

        isLoading -> Loading()

        isSuccess -> SuccessScreen(navController)

        validateRequested && !isSuccess -> FailureScreen(
            navController,
            message = "Detectamos uma possível troca de SIM não autorizada!",
            icon = Icons.Default.SimCardAlert,
            description = "chip",
            onRetry = { navController.navigate("sim") },
        )

        isFormVisible -> Scaffold(
            topBar = { ReturnTopBar(navController) },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Validação SIM SWAP",
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    Phone(
                        telefone = phoneNumber,
                        onTelefoneChange = { phoneNumber = it },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomButton(
                        text = "Validar",
                        onClick = {
                            validateRequested = true
                            isFormVisible = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        )
    }
}

fun validatePhoneNumber(phoneNumber: String): Boolean {
    return phoneNumber.length == 15
}
