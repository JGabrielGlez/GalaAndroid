package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.feature.clients.data.local.FakeClientsRepository
import com.drgabo.galaandroid.navigation.AppDestinations
import com.drgabo.galaandroid.core.ui.components.ClientCardDetail
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal
import com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme

@Composable
fun OwnerClientsScreen(
    currentRoute: String?,
    onNavigate: (String) -> Unit,
    uiState: OwnerClientsUiState,
    onQueryChange: (String) -> Unit
) {
    ScaffoldPrincipal(
        nombrePantalla = "Clientes",
        onFabClick = {},
        showFab = true,
        searchBarPlaceholder = "Buscar cliente",
        showSearchBar = true,
        searchBarQuery = uiState.query,
        onSearchBarOnQueryChange = onQueryChange,
        esPantallaClientes = true,
        currentRoute = currentRoute,
        onNavigate = onNavigate,
    ) {
        if (uiState.isLoading) {
            item {
                GalaText(texto = "Cargando clientes")
            }
        } else if (uiState.mostrarEstadoVacio) {
            item { GalaText(texto = "No hay clientes registrados") }
        } else if (uiState.mostrarSinResultados) {
            item { GalaText(texto = "No se encontraron coincidencias") }
        } else {
            items(uiState.clientesFiltrados) { client ->
                ClientCardDetail(
                    nombre = client.nombre,
                    ultimaVisita = client.ultimaVisitaAt,
                    noCitas = client.appointmentCount ?: 0
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun ListaCompleta() {
    GalaAndroidTheme {
        OwnerClientsScreen(
            currentRoute = AppDestinations.OWNER_CLIENTS,
            onNavigate = {},
            uiState = OwnerClientsUiState(
                clientes = FakeClientsRepository().getClients()
            ),
            onQueryChange = {},
        )
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun ListaVacia() {
    GalaAndroidTheme {
        OwnerClientsScreen(
            currentRoute = AppDestinations.OWNER_CLIENTS,
            onNavigate = {},
            uiState = OwnerClientsUiState(
                clientes = emptyList(),
                isLoading = false
            ),
            onQueryChange = {},
        )
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun CargandoLista() {
    GalaAndroidTheme {
        OwnerClientsScreen(
            currentRoute = AppDestinations.OWNER_CLIENTS,
            onNavigate = {},
            uiState = OwnerClientsUiState(
                isLoading = true
            ),
            onQueryChange = {},
        )
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun NoResultados() {
    GalaAndroidTheme {
        OwnerClientsScreen(
            currentRoute = AppDestinations.OWNER_CLIENTS,
            onNavigate = {},
            uiState = OwnerClientsUiState(
                query = "hola",
                // El filtrado vive en el UiState, no en el repository.
                clientes = FakeClientsRepository().getClients()
            ),
            onQueryChange = {},
        )
    }
}
