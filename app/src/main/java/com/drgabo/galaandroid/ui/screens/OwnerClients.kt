package com.drgabo.galaandroid.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme


@Composable
fun OwnerClients(){
    ScaffoldPrincipal(
        nombrePantalla = "Clientes",
        onFabClick = {},
        showFab = true,
        ) {
        //será la lazy column de todas las card de los clientes, sin olvidar la parte del search bar
    }
}


@Preview(showBackground = true, widthDp = 390)
@Composable
fun MostrarPantalla(){
    GalaAndroidTheme {
        OwnerClients()
    }
}