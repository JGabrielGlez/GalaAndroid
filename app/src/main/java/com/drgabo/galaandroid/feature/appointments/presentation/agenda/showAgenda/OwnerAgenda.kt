package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda

import androidx.compose.runtime.Composable
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal

@Composable
fun OwnerAgenda(
    nombrePantalla: String = "Agenda",
    currentRoute: String?,
    onNavigate:(String)->Unit
){
    ScaffoldPrincipal(
        nombrePantalla=nombrePantalla,
        showFab = true,
        currentRoute = currentRoute,
        onNavigate = onNavigate
    ) {
        item { GalaText(texto = "Agenda provisional") }
    }
}

