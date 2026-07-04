package com.drgabo.galaandroid.viewmodels

import kotlinx.coroutines.flow.update
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drgabo.galaandroid.data.AppointmentStatus
import com.drgabo.galaandroid.data.Client
import com.drgabo.galaandroid.data.HistorialRecienteDto
import com.drgabo.galaandroid.data.PaymentStatus
import com.drgabo.galaandroid.views.state.OwnerClientsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.drgabo.galaandroid.data.FakeClientsRepository
import com.drgabo.galaandroid.data.ClientsRepository

//Mantere el estado privado de UIState y el público
//cargar los clientes y actuaizar el query, limpuar la búsqueda
/*
* - MutableStateFlow(OwnerClientsUiState())
  - StateFlow
  - funciones como:
      - loadClients()
      - onQueryChange(query: String)
      - onClearSearch()

* */
class OwnerClientsViewModel(
    private val clientsRepository: ClientsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(OwnerClientsUiState())
    //_uiState es modificada por lo que es el viewModel



    //esta publica es la que la UI está observando
    val uiState: StateFlow<OwnerClientsUiState> = _uiState.asStateFlow()




    fun loadClients() {
        _uiState.update { state ->
            //TODO cargar los datos de la api
            state.copy(
                isLoading = true,
                errorMessage = null,
            )
        }
        _uiState.update { state ->
            state.copy(
                clientes = clientsRepository.getClients(),
                isLoading = false
            )
        }
    }

    fun onQueryChange(newQuery: String) {
        _uiState.update { state ->
            state.copy(
                query = newQuery
            )
        }
    }

    fun onClearSearch() {
        _uiState.update { state ->
            state.copy(
                query = ""
            )
        }
    }

}

class OwnerClientsViewModelFactory(
    private val clientsRepository: ClientsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OwnerClientsViewModel::class.java))
            return OwnerClientsViewModel(clientsRepository) as T
        throw IllegalArgumentException("ViewModel desconocido")
    }
}

