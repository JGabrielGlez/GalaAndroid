package com.drgabo.galaandroid.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.ui.components.*
import com.drgabo.galaandroid.ui.theme.EstadoConfirmada
import com.drgabo.galaandroid.ui.theme.EstadoConfirmadaFondo
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerDashboard(nombrePantalla: String = "Hola, María") {
    //var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            DashboardHeader(userName = "María")
        },
        bottomBar = {
            NavBar()
        },
        floatingActionButton = {
            FAB(onClick = {})
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
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
}

@Preview
@Composable
fun MostrarAgenda() {
    GalaAndroidTheme {

        OwnerDashboard()
    }
}