package br.com.fiap.antifraude.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.antifraude.components.ErrorCard
import br.com.fiap.antifraude.components.layout.ReturnTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FailureScreen(
    navController: NavController,
    message: String,
    icon: ImageVector,
    description: String,
    onRetry: () -> Unit,
) {
    Scaffold(
        topBar = { ReturnTopBar(navController) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ErrorCard(
                    navController,
                    message,
                    icon,
                    description,
                    onRetry
                )
            }
        }
    )
}
