package com.drgabo.galaandroid.feature.appointments.presentation.summary.showSummary


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.core.ui.components.AppoinmentDetailCard
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal
import com.drgabo.galaandroid.core.ui.components.SummaryCardsRow
import com.drgabo.galaandroid.core.ui.theme.AcentoSuave
import com.drgabo.galaandroid.core.ui.theme.EstadoConfirmada
import com.drgabo.galaandroid.core.ui.theme.EstadoConfirmadaFondo
import com.drgabo.galaandroid.core.ui.theme.MonstserratFamily
import com.drgabo.galaandroid.core.ui.theme.Typography
import com.drgabo.galaandroid.navigation.AppDestinations
import com.drgabo.galaandroid.navigation.AppHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerDashboard(
    nombrePantalla: String = "Inicio",
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    //var presses by remember { mutableIntStateOf(0) }
    ScaffoldPrincipal(
        showFab = true,
        nombrePantalla = nombrePantalla,
        currentRoute = currentRoute,
        onNavigate = onNavigate
    ) {

        item { SummaryCardsRow() }
        item {
            Text(
                text = "Miércoles 7 de abril",
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = MonstserratFamily,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
        item {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment =
                    Alignment.CenterVertically

            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(0.dp)
                        .width(120.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            AcentoSuave
                    )

                ) {
                    GalaText(
                        "Activas",
                        colorTexto = Color.Black,
                        peso = FontWeight.SemiBold,
                        estilo = Typography.labelSmall,
                        modifier = Modifier
                    )
                }
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                        .width(120.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            AcentoSuave
                    )

                ) {

                    GalaText(
                        "Canceladas",
                        colorTexto = Color.Black,
                        peso = FontWeight.SemiBold,
                        estilo = Typography.labelSmall,
                        modifier = Modifier
                    )
                }
            }


        }

        items(7) {
            AppoinmentDetailCard(
                nombreCliente = "Mariana Salazar",
                servicio = "Corte de cabello",
                duracion = "120 minutos",
                horaInicio = "12:00 AM",
                mensajeBagde = "Confirmada",
                colorBagde = EstadoConfirmadaFondo,
                colorTextoBagde = EstadoConfirmada,
            )
        }
    }
}

@Preview
@Composable
fun MostrarAgenda() {
    OwnerDashboard(
        currentRoute = AppDestinations.OWNER_AGENDA,
        onNavigate = {},
        nombrePantalla = "Gabriel")

}

