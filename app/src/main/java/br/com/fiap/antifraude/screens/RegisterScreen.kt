package br.com.fiap.antifraude.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.CustomButton
import br.com.fiap.antifraude.components.Loading
import br.com.fiap.antifraude.components.forms.Phone
import br.com.fiap.antifraude.components.forms.CPF
import br.com.fiap.antifraude.components.layout.ReturnTopBar
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }

    var nomeError by remember { mutableStateOf(false) }
    var cpfError by remember { mutableStateOf(false) }
    var enderecoError by remember { mutableStateOf(false) }
    var telefoneError by remember { mutableStateOf(false) }
    var showToast by remember { mutableStateOf(false) }

    var isLoading by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }

    val context = LocalContext.current

    LaunchedEffect(showToast) {
        if (showToast) {
            Toast.makeText(context, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
            showToast = false
        }
    }

    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(3000)
            isLoading = false
            isSuccess = true
        }
    }

    if (isLoading) {
        Loading()
    } else if (isSuccess) {
        SuccessScreen(navController)
    } else {
        Scaffold(
            topBar = { ReturnTopBar(navController) },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Cadastro de Usuário",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    OutlinedTextField(
                        value = nome,
                        maxLines = 1,
                        onValueChange = { nome = it },
                        label = { Text("Nome") },
                        isError = nomeError,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (nomeError) {
                        Text(
                            "Por favor, insira seu nome",
                            color = Color.Red,
                            style = TextStyle(fontSize = 12.sp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    CPF(
                        cpf = cpf,
                        onCpfChange = { cpf = it },
                        isError = cpfError,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = endereco,
                        onValueChange = { endereco = it },
                        label = { Text("Endereço") },
                        isError = enderecoError,
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (enderecoError) {
                        Text(
                            "Por favor, insira seu endereço",
                            color = Color.Red,
                            style = TextStyle(fontSize = 12.sp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Phone(
                        telefone = telefone,
                        onTelefoneChange = { telefone = it },
                        isError = telefoneError,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomButton(
                        text = "Cadastrar",
                        onClick = {
                            nomeError = nome.isEmpty()
                            cpfError = cpf.length != 14
                            enderecoError = endereco.isEmpty()
                            telefoneError = telefone.length != 15

                            if (!(nomeError || cpfError || enderecoError || telefoneError)) {
                                isLoading = true
                            } else {
                                Toast.makeText(
                                    context,
                                    "Por favor, preencha todos os campos corretamente.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        )
    }
}