package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda

import androidx.compose.runtime.Composable
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal

@Composable
fun OwnerAgenda(
    currentRoute: String?,
    onNavigate:(String)->Unit
){
    OwnerAgendaRoot(
        currentRoute =currentRoute,
        onNavigate=onNavigate
    )
}

