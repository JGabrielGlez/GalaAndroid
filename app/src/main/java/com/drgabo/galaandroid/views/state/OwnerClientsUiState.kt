package com.drgabo.galaandroid.views.state

import com.drgabo.galaandroid.data.Client

data class OwnerClientsUiState(
    //Aquí se cargan los valores o estados que va a tener la pantalla
    val query: String="",
    val clientes: List<Client> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage:String?="",
    val clientesFiltrados: List<Client> = emptyList(),

)

