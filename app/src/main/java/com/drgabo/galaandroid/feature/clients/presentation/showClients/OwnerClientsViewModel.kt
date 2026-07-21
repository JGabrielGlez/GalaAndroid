package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drgabo.galaandroid.feature.clients.domain.usecases.GetOwnerClientsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OwnerClientsViewModel(
    //1: Dependecias: Se reciben lo que son los use cases que la pantalla necesita
    //el View Model no recrea el repository directamente
    //en este caso solo tengo lo que es un useCase validado y qué sí se puede mostrar para esta pantalla inicial
    private val getClientsUseCase: GetOwnerClientsUseCase
) : ViewModel() {
    //2: Estados, el interno y el externo, el interno es privado mientras y con mutableStateFlow porque puede mutar, mientras que el externo es público y se trata como stateFlow
    //empieza siempre en estado de carga
    private val _uiState =
        MutableStateFlow<OwnerClientsUiState>(OwnerClientsUiState.Loading)
    val uiState: StateFlow<OwnerClientsUiState> = _uiState.asStateFlow()

    //3. Carga inicial de los datos, en este caso de los clientes, es la función que se ejecuta al iniciar lo que es el VM
    init {
        loadClients()
    }

    //3. Carga y actualización de información:
    //la función debe de ejecutar el respectivo useCase
    fun loadClients() {
        //Representa lo que es la carga inicial o la carga por defecto, el estado inicial del VM
        viewModelScope.launch {
            //Cambiar los estados mediante el estado privado, para actualizar lo que son los estados, lo que son los objetos que implementan la sealed interface

            //Primero se comunica a la UI que comenzó la operación
            _uiState.value = OwnerClientsUiState.Loading

            //se solicita la informacipon mediante el use case y se envía un evento
            getClientsUseCase()
                .onSuccess { data ->
                    //Ejecuta el use case, en este momento ya tiene la lista de clientes, por lo que Data representa la respuesta, si no hay información se presenta el estado de empty, si sí, el de success puro
                    _uiState.value = if (data.isEmpty()) OwnerClientsUiState.Empty
                    else
                        OwnerClientsUiState.Success(
                            clients = data,
                            //Esto es redundante porque el uiState ya lo hace, pero lo pongo solo para entender mejor el funcionamiento
                            query = ""
                        )
                }
                .onFailure {
                    _uiState.value = OwnerClientsUiState.Error(
                        message = "No se pudieron cargar los clientes, intente más tarde."
                    )
                }
        }
    }
}
















