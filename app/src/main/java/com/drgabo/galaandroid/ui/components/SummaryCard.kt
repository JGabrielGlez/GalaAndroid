package com.drgabo.galaandroid.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.ui.theme.MonstserratFamily

@Composable
fun SummaryCard(
    numero: String,
    mensaje: String,
    modifier: Modifier = Modifier,
    colorNumero: Color = Color.Black,
    colorMensaje: Color = Color.Black.copy(alpha = .60f)
) {
    Card(
        colors = CardDefaults
            .cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
            ),
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(all = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = numero, color = colorNumero,
                fontFamily = MonstserratFamily,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold

            )
            Text(
                text = mensaje,
                color = colorMensaje,
                fontFamily = MonstserratFamily,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1

            )
        }

    }
}


@Composable
fun SummaryCardsRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SummaryCard(
            numero = "12",
            mensaje = "Total de citas",
            modifier =
                Modifier
                    .weight(1f)
        )
        SummaryCard(
            numero = "12",
            mensaje = "Confirmadas",
            modifier =
                Modifier
                    .weight(1f)
        )
        SummaryCard(
            numero = "12",
            mensaje = "Pendientes",
            modifier =
                Modifier
                    .weight(1f)
        )
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun ShowCards() {
    GalaAndroidTheme {
       SummaryCardsRow(
           modifier = Modifier
               .padding(horizontal = 20.dp, vertical = 16.dp)
       )
    }
}


@Preview(showBackground = true, widthDp = 360)
@Composable
fun ShowGalaCard() {
    GalaAndroidTheme {
        SummaryCard(numero = "12", mensaje = "Citas")
    }

}