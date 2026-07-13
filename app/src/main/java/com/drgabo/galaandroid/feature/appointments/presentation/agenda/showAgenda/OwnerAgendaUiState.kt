package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda


//este archivo solo debe conocer lo que son los modelos de dominio, porque las demás responsabilidades
//ya se delegaron a los otros archivos como lo son las capas de data y domain
//este solo se preocupa por los estados que puede tener esta pantalla, y está relacionada con los appointments
import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

//Objeto que representa el estado completo de una pantalla en un momento dado
// eslo que la UI necesita para dibujarse
//en este caso son necesarias las citas, estados con citas, vacío, y el de error y loading
//UiState debe guardar solo lo que la UI necesita para renderizarse.
data class OwnerAgendaUiState(
    // Antes se llamaba appointmentsList; el tipo List ya expresa que se trata de una lista.
    val appointments: List<Appointment> = emptyList(),
    val isLoading: Boolean = false,
    // Distingue entre "aún no se ha consultado" y "la API respondió sin citas".
    val hasLoadedOnce: Boolean = false,
    val errorMessage: String? = null,
    val selectedAppointment: Appointment? = null,
    // Antes se llamaba showCreateNewAppointment; ahora describe una condición visible.
    val isCreateAppointmentSheetVisible: Boolean = false,
    //mostrar fecha actual
    val currentDate: LocalDate = LocalDate.now()
) {
    val showFormattedCurrentDay: String
        get() =
            currentDate.format(
                DateTimeFormatter.ofPattern(
                    "EEEE d 'de' MMMM",
                    Locale("es", "MX")
                )
            ).replaceFirstChar { it.uppercase() }


    //Retornar la lista de appintments agrupadas
    val groupedAppointments:Lis
    // Antes, hasData era genérico; ahora el nombre indica qué datos se comprueban.
    val hasAppointments: Boolean
        get() = appointments.isNotEmpty()

    // Antes no se distinguía la carga inicial de una actualización con datos existentes.
    val showFullScreenLoading: Boolean
        get() = isLoading && !hasAppointments

    val showRefreshing: Boolean
        get() = isLoading && hasAppointments

    // hasLoadedOnce evita mostrar el estado vacío antes de consultar la API por primera vez.
    val showEmptyState: Boolean
        get() = hasLoadedOnce &&
                !isLoading &&
                errorMessage == null &&
                !hasAppointments

    // Antes terminaba en State, una palabra redundante dentro de una clase UiState.
    val showFullScreenError: Boolean
        get() = hasLoadedOnce &&
                !isLoading &&
                errorMessage != null &&
                !hasAppointments

    // Antes, showNormalError no explicaba su representación; este error conserva el contenido.
    val showErrorSnackbar: Boolean
        get() = errorMessage != null && hasAppointments

    // Antes dependía de !isLoading y ocultaba la lista durante el polling o una recarga.
    val showContent: Boolean
        get() = hasAppointments


    // Se eliminaron showAppointment/hideAppointment: que selectedAppointment sea nulo o no
    // ya es la única fuente de verdad para mostrar u ocultar el detalle.
    // También se eliminaron showCreateAppointmentSheet/closeCreateAppointmentSheet:
    // duplicaban el booleano base y "close" describe un evento, no un estado.

}
