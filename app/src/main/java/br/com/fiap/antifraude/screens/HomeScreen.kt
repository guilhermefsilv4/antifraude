package br.com.fiap.antifraude.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.antifraude.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary),
                title = {
                    Text(
                        "Home",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(
                        onClick = { /* Ação para abrir o perfil */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.account_circle_24),
                            contentDescription = "User Profile",
                            modifier = Modifier.fillMaxHeight()
                                .size(40.dp)
                                .padding(end = 5.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }
            )
        },
        content = { padding ->
            Column(
                Modifier.padding(padding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TaskGridScreen(
                    navController = navController
                )
            }
        }
    )
}
