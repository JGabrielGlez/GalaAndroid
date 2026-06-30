package com.drgabo.galaandroid.views.state

import com.drgabo.galaandroid.data.Client

data class OwnerClientsUiState(
    //Aquí se cargan los valores o estados que va a tener la pantalla
    val query: String = "",
    val clientes: List<Client> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
) {
    val clientesFiltrados: List<Client>
        get() = if (query.isBlank()) {
            clientes
        } else {
            clientes.filter { it.nombre.contains(query, ignoreCase = true) }
        }

    val mostrarLista: Boolean
        get()=clientesFiltrados.isNotEmpty()

    val mostrarEstadoVacio: Boolean
        get()= !isLoading && errorMessage == null && clientes.isEmpty()

    val mostrarSinResultados: Boolean
        get()=!isLoading && query.isNotBlank() && clientesFiltrados.isEmpty() && clientes.isNotEmpty()

}

