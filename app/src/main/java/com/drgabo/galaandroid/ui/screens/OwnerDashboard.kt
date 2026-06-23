package com.drgabo.galaandroid.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.ui.components.*
import com.drgabo.galaandroid.ui.theme.EstadoConfirmada
import com.drgabo.galaandroid.ui.theme.EstadoConfirmadaFondo
import com.drgabo.galaandroid.ui.theme.MonstserratFamily
import com.drgabo.galaandroid.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerDashboard(nombrePantalla: String = "Hola, María") {
  //var presses by remember { mutableIntStateOf(0) }
ScaffoldPrincipal(showFab = true, nombrePantalla = nombrePantalla) {

  SummaryCardsRow()
  Text(
    text = "Miércoles 7 de abril",
    style = Typography.bodyLarge,
    fontWeight = FontWeight.Bold,
    fontFamily = MonstserratFamily,
    modifier = Modifier.padding(vertical = 12.dp)

  )
  AppoinmentDetailCard(
    nombreCliente = "Mariana Salazar",
    servicio = "Corte de cabello",
    duracion = "120 minutos",
    horaInicio = "12:00 AM",
    mensajeBagde = "Confirmada",
    colorBagde = EstadoConfirmadaFondo,
    colorTextoBagde = EstadoConfirmada,

    )
  AppoinmentDetailCard(
    nombreCliente = "Mariana Salazar",
    servicio = "Corte de cabello",
    duracion = "120 minutos",
    horaInicio = "12:00 AM", mensajeBagde = "Confirmada",
    colorBagde = EstadoConfirmadaFondo,
    colorTextoBagde = EstadoConfirmada,


    )
  AppoinmentDetailCard(
    nombreCliente = "Mariana Salazar",
    servicio = "Corte de cabello",
    duracion = "120 minutos",
    horaInicio = "12:00 AM", mensajeBagde = "Confirmada",
    colorBagde = EstadoConfirmadaFondo,
    colorTextoBagde = EstadoConfirmada,


    )
  AppoinmentDetailCard(
    nombreCliente = "Mariana Salazar",
    servicio = "Corte de cabello",
    duracion = "120 minutos",
    horaInicio = "12:00 AM", mensajeBagde = "Confirmada",
    colorBagde = EstadoConfirmadaFondo,
    colorTextoBagde = EstadoConfirmada,


    )
}
}

@Preview
@Composable
fun MostrarAgenda() {
    OwnerDashboard(nombrePantalla = "Gabriel")

}