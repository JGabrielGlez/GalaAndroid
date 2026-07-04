package com.drgabo.galaandroid.views.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drgabo.galaandroid.viewmodels.OwnerClientsViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.data.FakeClientsRepository
import com.drgabo.galaandroid.navigation.AppDestinations
import com.drgabo.galaandroid.viewmodels.OwnerClientsViewModelFactory
import com.drgabo.galaandroid.views.components.ClientCardDetail
import com.drgabo.galaandroid.views.components.GalaText
import com.drgabo.galaandroid.views.components.ScaffoldPrincipal

import com.drgabo.galaandroid.views.theme.GalaAndroidTheme


@Composable
fun OwnerClients(
    currentRoute:String?,
    onNavigate:(String)-> Unit
) {
    //remember porque la pantalla se puede volver a renderizar, por lo que no
    //se quiere perder lo que se tenía dentro de la pantalla al suceder.
    val repository = remember{ FakeClientsRepository() }
    val factory = remember {
        OwnerClientsViewModelFactory(repository)
    }
    val viewModel: OwnerClientsViewModel = viewModel(factory=factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //Se activa al lanzar la pantalla
    LaunchedEffect(Unit) {
        viewModel.loadClients()
    }

    ScaffoldPrincipal(
        nombrePantalla = "Clientes",
        onFabClick = {},
        showFab = true,
        searchBarPlaceholder = "Buscar cliente",
        showSearchBar = true,
        searchBarQuery = uiState.query,
        //:: referencia una función sin ejecutarla en ese momento.
        onSearchBarOnQueryChange = viewModel::onQueryChange,
        esPantallaClientes = true,
        currentRoute = currentRoute,
        onNavigate = onNavigate,
        ) {

        if (uiState.isLoading) {
            item {
                GalaText(texto = "Cargando clientes")
            }
        }else if (uiState.mostrarEstadoVacio){
            item { GalaText(texto = "No hay clientes registrados") }
        }else if(uiState.mostrarSinResultados){
            item{GalaText(texto = "No se encontraron coincidencias")}
        }else{
            //significa que ya pasó todos los filtros y sí hay algo que renderizar
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

class OwnerClientsRoot(){
    //dentro de esta clase irá todo lo que es la lógica de conexión,
    //lo que no se de renderizado; aunque cabe mencionar que dentro de
    //Este archivo se mandará a llamar a la clase que pinta la pantalla.
}


@Preview(showBackground = true, widthDp = 390)
@Composable
fun MostrarPantalla() {
    GalaAndroidTheme {
        OwnerClients(
            currentRoute = AppDestinations.OWNER_CLIENTS,
            onNavigate = {}
        )
    }
}
