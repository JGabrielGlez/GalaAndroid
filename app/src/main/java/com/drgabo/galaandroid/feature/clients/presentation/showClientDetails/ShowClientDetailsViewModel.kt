package com.drgabo.galaandroid.feature.clients.presentation.showClientDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drgabo.galaandroid.feature.clients.domain.usecases.GetOwnerClientByIdUseCase
import com.drgabo.galaandroid.feature.clients.presentation.showClients.OwnerClientsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShowClientDetailsViewModel(
    private val getOwnerClientUseCase: GetOwnerClientByIdUseCase,
): ViewModel() {
    //estado interno y externo, es decir, el modificable y el de solo lectura
    private val _uiState = MutableStateFlow<ShowClientDetailsUiState>(ShowClientDetailsUiState.Loading)
    val uiState: StateFlow<ShowClientDetailsUiState> = _uiState.asStateFlow()

    //Después de cargar las variables necesarias, aquí se requiere declarar las funciones que van a estar funcionando, aquellas que harán posible que el VM mande los respectivos estados
    fun loadClient(id:String){
        //como aún no sé si será por caché o por consulta, la haré con corrutina
        viewModelScope.launch {
            //cada que carga los clientes es necesario que la ui reciba lo que es el evento, para que se pueda recomponer y mostrar las respectivas pantallas, por lo que al iniciar este bloque, como estará cargando los datos, debe setearse el valor a loading
            _uiState.value = ShowClientDetailsUiState.Loading


            //Una vez ya mostrando el respectivo estado, lo que se debe de hacer es mandar a llamar al use case
            getOwnerClientUseCase(id)
                .onSuccess {
                    //Como yo sé que nunca se mandará a llamar un id que no tiene datos, no es necesario usar el estado de empty, por lo que es directamente actualizar el uiState
                   data->//Importante siempre actualizar la ui State, del contrario no se guarda nada
                   _uiState.value = ShowClientDetailsUiState.Success(client = data)
                }
                .onFailure {
                    _uiState.value=ShowClientDetailsUiState.Error(
                        message = "El cliente buscado no existe, intentar de nuevo"
                    )
                }
        }
    }
}