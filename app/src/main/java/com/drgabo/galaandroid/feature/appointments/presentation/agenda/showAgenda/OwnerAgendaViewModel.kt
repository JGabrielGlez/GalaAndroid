package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drgabo.galaandroid.core.util.SnackBarManager
import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment
import com.drgabo.galaandroid.feature.appointments.domain.repositories.AppointmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/*
* Responsabilidades del VM
* -Recibir las dependencias , este archivo necesita el repository
* debe recibirlo mediante el el constructor, unicamente conoce el contrato del repository
*
* -Mantiene lo que es la versión actual de la UIState, es privado porque solo VM debe modificarlo
* La pantalla puede observar el estado, mas no modificarlo
*
* -Cargar las citas, debe tener un método que permita cargar los datos
*  Esta función debe tener toda la lógica como:
*   indicar que comenzó la cargfa
*   limpiar errores anteriores
*   Pedir citas al repository
*   Guardar los resultados
*   Indicar que la carga terminó.
*
* -Manejar errores: la pantalla solo necesita saber qué estado debe de mostrar al tener un error, no qué falló.
*
* -Recibir eventos de la pantalla
*
* -Conservar el estado
*
* Resumen: ell VM decide estado y persiste los datos; mientras que la pantalla decide como dibujarlo
*
* Regla: El ViewModel recibe eventos de la UI, consulta el dominio o los repositories y produce un nuevo UiState.
*
* Recibe eventos y decide cómo modificar el estado de la UiState
*
* */

class OwnerAgendaViewModel(
    //recibe la dependencia del repository
    //El repository se recibe por constructor para que desde afuera puedas decidir si entregarle: la fake o la de api
    private val appointmentRepository: AppointmentRepository

    //posteriormente la clase hereda de VM
) : ViewModel() {
    //Aquí se definene la mutación de los estados y el estado que sí es observable por la screen
    private val _uiState = MutableStateFlow(
        OwnerAgendaUiState
            ()
    )

    //asStateFlow lo que hace es exponer una vista protegida del mismo estado
    val uiState: StateFlow<OwnerAgendaUiState> = _uiState.asStateFlow()

    //una vez que ya se tienen definidos los estados modificables y el observable, lo que sigue es empezar a cargar los datos que ya se tienen hechos

    fun showSnackbarMessage(message:String){
        viewModelScope.launch {
            SnackBarManager.showMessage(message)
        }
    }

    //La función de carga debe usar 3 estapas, que son comenzar la carga, pedir los datos y publicar el resultado
    fun loadAppointments() {
        viewModelScope.launch {
            //Actualizar el estado para decir que se está cargando
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }

            //Ahora sigue traer los datos
            try {
                val agendaDays = appointmentRepository.getAgendaDays()
                //publicar le resultado de lo obtenido, que tiene que volver a dictar que ya no se está cargando, es decir, que la operación ya terminó

                _uiState.update { currentState ->
                    currentState.copy(
                        agendaDays = agendaDays,
                        isLoading = false,
                        hasLoadedOnce = true,
                        //nota: siempre se debe de setear a null aunque se sepa que la opearción salió correcta, porque no se sabe si alguna otra funció haya dejado el mensaje de error persistido
                        errorMessage = null
                    )
                }
            } catch (
                error: Exception
            ) {
                //settear el estado a problema y que no está cargando
                _uiState.update { currenState ->
                    currenState.copy(
                        isLoading = false,
                        hasLoadedOnce = true,
                        errorMessage = "Hubo un error al cargar los datos, intente más tarde"
                    )
                }
                //como está en el catch y siempre se settea el mensaje de error, es imposible que el errorMessage sea nulo, por eso se le agregan los !!, para decir que es imposible este valor.
                showSnackbarMessage(uiState.value.errorMessage!!)

            }

        }
    }




    //dejar de mostrar un error, es decir, después de notificarlo al usuario

    fun onErrorConsumed() {

        //lógica de lo que se debe de hacer después de haber mostrado el error
        //En este momento hay un mensaje de error, por lo que hay que limpiarlo
        _uiState.update { currentState ->
            currentState.copy(
                //limpiando el error
                errorMessage = null
            )
        }

    }

    // La pantalla ya posee el objeto de la lista que dibujó; antes se buscaba otra vez por ID.
    // Recibirlo completo evita una consulta redundante y no requiere carga ni corrutina.
    fun onAppointmentSelected(appointment: Appointment) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedAppointment = appointment
            )
        }
    }

    //evento de cerrar la card de detalle cita
    fun onAppointmentUnselected() {
        //solo va a quitar lo que es el appointment seleccionado
        _uiState.update {
            currentState->
            currentState.copy(
                selectedAppointment = null
            )
        }
    }

    // Antes abrir/cerrar se modelaba con derivadas duplicadas en UiState.
    // Ahora son eventos y el UiState conserva una sola fuente de verdad.
    fun onCreateAppointmentRequested() {
        _uiState.update { currentState ->
            currentState.copy(
                isCreateAppointmentSheetVisible = true
            )
        }


    }

    fun onCreateAppointmentDismissed() {
        _uiState.update { currentState ->
            currentState.copy(
                isCreateAppointmentSheetVisible = false
            )
        }
    }


}
