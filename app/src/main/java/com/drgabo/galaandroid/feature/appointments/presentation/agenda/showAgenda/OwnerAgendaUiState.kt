package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda


//este archivo solo debe conocer lo que son los modelos de dominio, porque las demás responsabilidades
//ya se delegaron a los otros archivos como lo son las capas de data y domain
//este solo se preocupa por los estados que puede tener esta pantalla, y está relacionada con los appointments
import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment

//Objeto que representa el estado completo de una pantalla en un momento dado
// eslo que la UI necesita para dibujarse
//en este caso son necesarias las citas, estados con citas, vacío, y el de error y loading
//UiState debe guardar solo lo que la UI necesita para renderizarse.
data class OwnerAgendaUiState(
    val appointmentsList: List<Appointment> = emptyList(),//por defecto lista vaca
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val selectedAppointment: Appointment? = null
){
    //mostrar la pantalla vacía cuando...
    val showEmptyState: Boolean
        get() =
            errorMessage ==null && appointmentsList.isEmpty() && !isLoading

    //mostrar estado de error completo
    val showFullScreenErrorState : Boolean
        get()=
            errorMessage!=null && !hasData

    //Este estado se puede usar cuando ya hay citas cargadas, pero ocurrió algún tipo de error
    //Esto ayuda a distinguir entre cuando se puede mostrar un error como toast o si debe de mostrarse
    //como
    val showNormalError: Boolean
        get()=
            errorMessage!=null && hasData
    //mostrar pantalla con contenido
    val showContent: Boolean
        get()=
            hasData && !isLoading

    //mostrar pantalla cuando hay datos
    val hasData: Boolean
        get()=
            appointmentsList.isNotEmpty()

}