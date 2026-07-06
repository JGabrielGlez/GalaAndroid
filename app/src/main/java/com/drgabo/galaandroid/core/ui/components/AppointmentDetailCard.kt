package com.drgabo.galaandroid.core.ui.components

import com.drgabo.galaandroid.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.core.ui.theme.EstadoConfirmada
import com.drgabo.galaandroid.core.ui.theme.EstadoConfirmadaFondo
import com.drgabo.galaandroid.core.ui.theme.MonstserratFamily
import com.drgabo.galaandroid.core.ui.theme.NeutroBlanco
import com.drgabo.galaandroid.core.ui.theme.NeutroBorde
import com.drgabo.galaandroid.core.ui.theme.TextoPrimario
import com.drgabo.galaandroid.core.ui.theme.TextoSecundario
import com.drgabo.galaandroid.core.ui.theme.Typography

@Composable
fun AppoinmentDetailCard(
    nombreCliente: String,
    servicio: String,
    duracion: String,
    horaInicio: String,

    mensajeBagde: String,
    colorBagde: Color,
    colorTextoBagde: Color,

    iconButtonIcon: com.drgabo.galaandroid.core.ui.components.GalaIcon? = null,
    iconOnClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        //aquí irá lo que es la hora actual, que siempre debe tener un
        //tamaño fijo, para no romper el layout
        Text(
            text = horaInicio,
            fontFamily = MonstserratFamily,
            style = Typography.bodyMedium,
            color = TextoSecundario
        )
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

            //Irán los tres textos apilados uno encima de otro, aunque serám
            //parte de un layout de 2 columnas, el badge será de 1/3
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment =
                    Alignment.Start
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (iconButtonIcon != null) {
                            GalaIconButton(
                                onClick = iconOnClick,
                                icon = iconButtonIcon
                            )
                        }

                        BadgeEstado(
                            mensaje = mensajeBagde,
                            colorFondo = colorBagde,
                            colorTexto = colorTextoBagde
                        )
                    }
                }
            }


        }
    }
}

@Preview
@Composable
fun Preview() {
    AppoinmentDetailCard(
        nombreCliente = "Jesús Gabriel",
        servicio = "Corte de cabello",
        duracion = "60 minutos",
        horaInicio = "12:00 AM",
        mensajeBagde = "Confirmada",
        colorBagde = EstadoConfirmadaFondo,
        colorTextoBagde = EstadoConfirmada,
        iconButtonIcon = GalaIcon.DrawableIcon(
            resId = R.drawable.whatsapp_icon,
            contentDes = "WhatsApp"
        )


    )
}
