package com.drgabo.galaandroid.feature.clients.presentation.showClients

import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem

sealed interface OwnerClientsUiState {
    //solo puede haber 4 estados para esta pantalla:
    //vacío, cargando, error y succes
    data object Loading : OwnerClientsUiState
    data object Empty : OwnerClientsUiState
    data class Error(
        val message: String
    ) : OwnerClientsUiState

    data class Success(
        //debe poder filtrar los queries enviados, para filtrar los respectivos clientes
        val clients: List<OwnerClientListItem>,
        val query: String = "" //Por defecto vacío, nunca nulo

    ) : OwnerClientsUiState {
        //aquí se usará la lógica de filtrado que serán estados derivados sencillos
        val filteredClients: List<OwnerClientListItem>
            get() {
                val cleanQuery = query.trim()
                return if (cleanQuery.isEmpty() || cleanQuery.isBlank())
                    clients
                else {
                    clients.filter { client ->
                        client.nombre.contains(other = cleanQuery, ignoreCase = true)
                    }
                }
            }
    }
}