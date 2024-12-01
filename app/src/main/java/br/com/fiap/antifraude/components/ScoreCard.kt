package br.com.fiap.antifraude.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScoreCard(
    navController: NavController,
    score: Int,
    icon: ImageVector,
    message: String,
) {
    val scoreColor = when (score) {
        in 0..300 -> MaterialTheme.colorScheme.error
        in 301..500 -> Color.Yellow
        in 501..700 -> MaterialTheme.colorScheme.primary
        in 701..1000 -> Color.Green
        else -> MaterialTheme.colorScheme.onBackground
    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(350.dp),
        shape = RoundedCornerShape(30.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Feedback",
                    tint = scoreColor,
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Seu score é de $score",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Resultado: $message",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = scoreColor
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomButton(
                        text = "Home",
                        onClick = { navController.navigate("home") },
                        type = ButtonType.Primary,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}