package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drgabo.galaandroid.feature.clients.domain.usecases.GetOwnerClientsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
                .onSuccess { clients ->
                    //Ejecuta el use case, en este momento ya tiene la lista de clientes, por lo que Data representa la respuesta, si no hay información se presenta el estado de empty, si sí, el de success puro
                    _uiState.value = if (clients.isEmpty()) OwnerClientsUiState.Empty
                    else
                        OwnerClientsUiState.Success(
                            clients = clients,
                            //Esto es redundante porque el uiState ya lo hace, pero lo pongo solo para entender mejor el funcionamiento
                            query = ""
                        )
                }
                .onFailure {

                    //Recibe un dato error, que se puede reutilizar si se quiere usar su contenido, por el momento no lo usaré ya que quiero mostrar un único mensaje fijo
                    _uiState.value = OwnerClientsUiState.Error(
                        message = "No se pudieron cargar los clientes, intente más tarde."
                    )
                }
        }
    }

    //Me faltó agregar la otra función que define qué se debe de hacer cuando el query cambia, en el VM se definen todas las funciones que permitan renderizar la pantalla o hacer más bien que esta funcione y sea reactiva, sin esta función que pondré, el buscador no hará nada realmente
    fun onQueryChange(query: String) {
        //Actualiza el estado, con update se Actualizan los valores que están dentro del mutableState
        _uiState.update { currentState ->
            //Hay que proteger y tener en cuenta que query solo existe en success
            //la comparación se puede hacer porque es una data class/object
            if (currentState is OwnerClientsUiState.Success) {
                //Se crea un nuevo estado con el texto actualizado
                currentState.copy(
                    query = query
                )
            } else {
                //Retorna el estado actual, que son todos menos success
                currentState
            }
        }
    }
}
















