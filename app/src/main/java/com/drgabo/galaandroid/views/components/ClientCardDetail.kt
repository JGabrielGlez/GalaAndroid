package com.drgabo.galaandroid.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.views.theme.AcentoSuave
import com.drgabo.galaandroid.views.theme.GalaAndroidTheme
import com.drgabo.galaandroid.views.theme.TextoSecundario
import com.drgabo.galaandroid.views.theme.Typography


@Composable
fun ClientCardDetail(
    nombre: String,
    ultimaVisita: String,
    noCitas: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        colors = CardDefaults.cardColors(contentColor = Color.Transparent)
    ) {Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    enabled = true,
                    onClick = { println(message = "Cliente presionado") }
                )
                .padding(vertical = 8.dp, horizontal = 12.dp),

            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //Círculo con la inicial
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(shape = CircleShape)
                    .background(color = AcentoSuave.copy(alpha = .7f))
                    .padding(4.dp),

                contentAlignment = Alignment.Center
            ) {
                GalaText(nombre.first().toString().uppercase(),
                    peso= FontWeight.SemiBold,
                    estilo = Typography.bodyLarge)
            }

            //columna con los datos
            Column(
                modifier = Modifier.weight(1f),

                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                GalaText(
                    texto = nombre,
                    peso = FontWeight.SemiBold
                )
                GalaText(
                    //TODO quitar la s de Citas cuando solo lleva 1 cita
                    texto = "$noCitas citas - Última visita: $ultimaVisita",
                    colorTexto = TextoSecundario,
                    estilo = Typography.bodySmall
                )
            }

            //divisor

        }
        HorizontalDivider(thickness = 1.dp, color = AcentoSuave, modifier = Modifier.fillMaxWidth())

    }
    }
}

@Preview
@Composable
fun MostrarCard() {
    GalaAndroidTheme {
        ClientCardDetail(nombre = "gabriel", ultimaVisita = "12 de junio", noCitas = 2)
    }
}
