package com.drgabo.galaandroid.views.screens

import androidx.compose.runtime.Composable
import com.drgabo.galaandroid.views.components.GalaText
import com.drgabo.galaandroid.views.components.ScaffoldPrincipal

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

