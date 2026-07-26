package com.drgabo.galaandroid.feature.clients.presentation.showClientDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal
import com.drgabo.galaandroid.feature.clients.data.local.OwnerClientsList
import com.drgabo.galaandroid.navigation.AppDestinations

@Composable
fun ShowClientDetailsScreen(
    currentRoute: String?,
    onNavigate: (String) -> Unit,
    uiState: ShowClientDetailsUiState
) {
    //
    ScaffoldPrincipal(
        nombrePantalla = "Detalles del cliente",
        showFab = false,
        esPantallaClientes = true,
        currentRoute = currentRoute,
        onNavigate = onNavigate
    ) {

        //Ahora en este caso lo que sigue es modelar como se ve la pantalla según los diferentes estados de la UI
        when (uiState) {
            is ShowClientDetailsUiState.Loading -> {
                item {
                    GalaText("Cargando cliente")
                }
            }

            is ShowClientDetailsUiState.Error -> {
                item {
                    GalaText(uiState.message)
                }
            }

            is ShowClientDetailsUiState.Success -> {
                item {
                    GalaText("Mostrando datos de ${uiState.client.nombre}")
                }
            }
        }
    }
}


//Esta variable lo único que hace es calcular el tab activo mediante la función que se creó dentro de AppDestinations
val tabSelected= AppDestinations.selectedTabRoute(AppDestinations.OWNER_CLIENT_DETAILS)

@Preview
@Composable
fun ShowLoadingState() {
    ShowClientDetailsScreen(
        currentRoute = tabSelected,
        onNavigate = {},
        uiState = ShowClientDetailsUiState.Loading
    )
}


@Preview
@Composable
fun ShowErrorState() {
    ShowClientDetailsScreen(
        currentRoute = tabSelected,
        onNavigate = {},
        uiState = ShowClientDetailsUiState.Error(
            message = "Hubo un error inesperado"
        )
    )
}


@Preview
@Composable
fun ShowSuccessState() {
    ShowClientDetailsScreen(
        currentRoute = tabSelected,
        onNavigate = {},
        uiState = ShowClientDetailsUiState.Success(
            client = OwnerClientsList.first()
        )
    )
}