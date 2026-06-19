package com.drgabo.galaandroid.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import com.drgabo.galaandroid.ui.theme.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.drgabo.galaandroid.ui.theme.MonstserratFamily


@Composable
fun AppoinmentDetailCard(
    nombreCliente: String,
    servicio: String,
    duracion: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = modifier.border(
            width = 1.dp,
            shape = RoundedCornerShape(12.dp),
            color = NeutroBorde
        ),
        colors = CardDefaults.cardColors(
            containerColor = NeutroBlanco
        )
    ) {
        Box(
            modifier=Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ){
            //Irán los tres textos apilados uno encima de otro, aunque serám
            //parte de un layout de 2 columnas, el badge será de 1/3
                Column(
                    modifier = Modifier.align(Alignment.TopStart),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    //Texto principal
                    Text(
                        text = nombreCliente,
                        fontFamily = MonstserratFamily,
                        color = TextoPrimario,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1
                    )
                    //Texto Secundario
                    Text(
                        text = servicio,
                        fontFamily = MonstserratFamily,
                        color = TextoSecundario,
                        style = MaterialTheme.typography.titleSmall,
                        maxLines = 1
                    )

                    //Texto Terciario
                    Text(
                        text = duracion,
                        fontFamily = MonstserratFamily,
                        color = TextoSecundario.copy(alpha = .7f),
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1
                    )
            }
            BadgeEstado(
                surfaceModifier= Modifier.align(Alignment.BottomEnd),
                mensaje = "Confirmada",
                colorFondo =EstadoConfirmadaFondo,
                colorTexto = EstadoConfirmada)
        }
    }
}

@Preview
@Composable
fun preview() {
    AppoinmentDetailCard(
        nombreCliente = "Jesús Gabriel",
        servicio = "Corte de cabello",
        duracion = "60 minutos"
    )
}
