package com.drgabo.galaandroid.views.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.views.components.ClientCardDetail
import com.drgabo.galaandroid.views.components.ScaffoldPrincipal
import com.drgabo.galaandroid.views.theme.AcentoSuave
import com.drgabo.galaandroid.views.theme.GalaAndroidTheme


@Composable
fun OwnerClients(){
    ScaffoldPrincipal(
        nombrePantalla = "Clientes",
        onFabClick = {},
        showFab = true,
        searchBarPlaceholder = "Buscar cliente",
        showSearchBar = true,
        searchBarQuery = "",
        onSearchBarOnQueryChange = {},
        esPantallaClientes=true,
        ) {

        //será la lazy column de todas las card de los clientes, sin olvidar la parte del search bar
        items(
            count = 7,

        ){
            ClientCardDetail(nombre="Gabrielon",
                ultimaVisita = "ayer",
                noCitas = 3
            )
          //  HorizontalDivider(thickness = 1.dp, color = AcentoSuave)

        }
    }
}


@Preview(showBackground = true, widthDp = 390)
@Composable
fun MostrarPantalla(){
    GalaAndroidTheme {
        OwnerClients()
    }
}
