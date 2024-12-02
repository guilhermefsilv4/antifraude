package br.com.fiap.antifraude.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import br.com.fiap.antifraude.utils.formatPhone

@Composable
fun Phone(
    telefone: String,
    onTelefoneChange: (String) -> Unit,
    isError: Boolean,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = telefone,
        onValueChange = {
            onTelefoneChange(formatPhone(it))
        },
        label = { Text("Telefone") },
        isError = isError,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
    if (isError) {
        Text(
            "Telefone deve ter 11 dígitos",
            color = Color.Red,
            style = TextStyle(fontSize = 12.sp)
        )
    }
}
