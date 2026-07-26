package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.navigation.AppDestinations
import com.drgabo.galaandroid.core.ui.components.ClientCardDetail
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal
import com.drgabo.galaandroid.feature.clients.data.local.OwnerClientsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerClientsScreen(
    currentRoute: String?,
    onNavigate: (String) -> Unit,
    uiState: OwnerClientsUiState,
    onQueryChange: (String) -> Unit,
    onFabClicked: ()->Unit
    //tiene que recibir la función que activa o desactiva el drawer
) {
    //el sealed interface de success es el unico estado que contiene lo que es el query para realizar la búsqueda, por lo que es el que se tiene que obtener
    val query = (uiState as? OwnerClientsUiState.Success)?.query.orEmpty()


    ScaffoldPrincipal(
        nombrePantalla = "Clientes",
        onFabClick = onFabClicked,
        showFab = true,
        searchBarPlaceholder = "Buscar cliente",
        showSearchBar = true,
        searchBarQuery = query,
        onSearchBarOnQueryChange = onQueryChange,
        esPantallaClientes = true,
        currentRoute = currentRoute,
        onNavigate = onNavigate,
    ) {

        //Ahora es necesario evaluar lo que es el estado, el tipo de estado que compose está recibiendo verdaderamente y hacer ciertas pantallas según el estado
        when (uiState) {
            //Se declara lo que es el estado porque en uno de ellos, es necesario almacenar y obtener ciertos valores, como lo es en el estado de cuando hay error
            is OwnerClientsUiState.Loading -> {
                item {
                    GalaText(texto = "Cargando los clientes...")
                }
            }

            is OwnerClientsUiState.Empty -> {
                item {
                    GalaText(texto = "No hay clientes que mostrar aún")
                }
            }


            is OwnerClientsUiState.Error -> {
                item {
                    GalaText(texto = uiState.message)
                }
            }

            is OwnerClientsUiState.Success -> {
                items(
                    uiState.filteredClients
                ) { client ->
                    ClientCardDetail(
                        nombre = client.nombre,
                        ultimaVisita = client.ultimaVisitaAt,
                        noCitas = client.appointmentsCount
                    )

                    ModalBottomSheet(
                        onDismissRequest = onFabClicked,
                        scrimColor = Color.Gray.copy(alpha = .3f)
                        ) {
                        GalaText(texto="Mostrando agregar clientes")
                    }
                }


            }
        }
//        if (uiState.isLoading) {
//            item {
//                GalaText(texto = "Cargando clientes")
//            }
//        } else if (uiState.mostrarEstadoVacio) {
//            item { GalaText(texto = "No hay clientes registrados") }
//        } else if (uiState.mostrarSinResultados) {
//            item { GalaText(texto = "No se encontraron coincidencias") }
//        } else {
//            items(uiState.clientesFiltrados) { client ->
//                ClientCardDetail(
//                    nombre = client.nombre,
//                    ultimaVisita = client.ultimaVisitaAt,
//                    noCitas = client.appointmentCount ?: 0
//                )
//            }
//        }
    }
}

//
//@Preview
//@Composable
//fun ShowErrorState(){
//    OwnerClientsScreen(
//        currentRoute = AppDestinations.OWNER_CLIENTS,
//        onNavigate = {},
//        uiState = OwnerClientsUiState.Error(message = "Hubo un error inesperado"),
//        onQueryChange = {},
//        onFabClicked = {}
//    )
//}
//
//
//@Preview
//@Composable
//fun ShowLoadingState(){
//    OwnerClientsScreen(
//        currentRoute = AppDestinations.OWNER_CLIENTS,
//        onNavigate = {},
//        uiState = OwnerClientsUiState.Loading,
//        onQueryChange = {},
//        onFabClicked = {}
//    )
//}
//
//
//@Preview
//@Composable
//fun ShowEmptyState(){
//    OwnerClientsScreen(
//        currentRoute = AppDestinations.OWNER_CLIENTS,
//        onNavigate = {},
//        uiState = OwnerClientsUiState.Empty,
//        onQueryChange = {},
//        onFabClicked = {}
//    )
//}
//
//
//@Preview
//@Composable
//fun ShowSuccessState(){
//    OwnerClientsScreen(
//        currentRoute = AppDestinations.OWNER_CLIENTS,
//        onNavigate = {},
//        uiState = OwnerClientsUiState.Success(
//            clients = OwnerClientsList,
//
//        ),
//        onQueryChange = {},
//        onFabClicked = {}
//    )
//}


@Preview
@Composable
fun ShowAddClientState(){
    OwnerClientsScreen(
        currentRoute = AppDestinations.OWNER_CLIENTS,
        onNavigate = {},
        uiState = OwnerClientsUiState.Success(
            clients = OwnerClientsList,
            showAddClient = true
            ),
        onQueryChange = {},
        onFabClicked = {}
    )
}