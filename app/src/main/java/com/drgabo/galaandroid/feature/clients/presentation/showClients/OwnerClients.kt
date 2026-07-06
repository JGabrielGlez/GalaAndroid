package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.compose.runtime.Composable


@Composable
fun OwnerClients(
    currentRoute:String?,
    onNavigate:(String)-> Unit
) {
    OwnerClientsRoot(
        currentRoute=currentRoute,
        onNavigate=onNavigate
    )
}
