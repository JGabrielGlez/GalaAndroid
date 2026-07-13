package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.core.ui.components.AppoinmentDetailCard
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal
import com.drgabo.galaandroid.core.ui.components.SummaryCardsRow
import com.drgabo.galaandroid.core.ui.theme.AcentoSuave
import com.drgabo.galaandroid.core.ui.theme.EstadoConfirmada
import com.drgabo.galaandroid.core.ui.theme.EstadoConfirmadaFondo
import com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.core.ui.theme.MonstserratFamily
import com.drgabo.galaandroid.core.ui.theme.Typography
import com.drgabo.galaandroid.feature.appointments.data.local.FakeAppointmenRepository
import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment
import com.drgabo.galaandroid.feature.appointments.domain.repositories.AppointmentRepository
import com.drgabo.galaandroid.navigation.AppDestinations


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerAgendaScreen(
    currentRoute: String?,
    onNavigate: (String) -> Unit,
    uiState: OwnerAgendaUiState,

    //callbacks de las funciones del VM
    // loadAppointments:()->Unit este es método directo del vm, lo que genera un acoplamiento
    onErrorConsumed: () -> Unit,
    onAppointmentUnselected: () -> Unit,
    onCreateAppointmentRequested: () -> Unit,
    onCreateAppointmentDismissed: () -> Unit,
    onAppointmentSelected: (Appointment) -> Unit

) {

    //var presses by remember { mutableIntStateOf(0) }
    ScaffoldPrincipal(
        showFab = true,
        nombrePantalla = "Agenda",
        currentRoute = currentRoute,
        onNavigate = onNavigate
    ) {
        //Esto siempre se muestra, aunque tengo que adaptar el summaryCardsRow para traer datos desde lo que es la api para el resumen
        item { SummaryCardsRow() }
        item {
            Text(
                text = "Miércoles 7 de abril",
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = MonstserratFamily,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
            // Evaluar primero los estados bloqueantes, porque impiden mostrar el contenido normal de la pantalla. Aquellos estados que son mutuamente excluyentes, es decir, no pueden existir dos al mismo tiempo, solo uno debe de mostrarse
            when {
                uiState.showEmptyState -> {
                    //mostrar estado vacío, por el momento será un texto sencillo
                   item {
                       GalaText(texto = "Estado vacío mostrándose")
                   }
                }

                uiState.showFullScreenLoading -> {
                    //mostrar que toda la pantalla está cargando
                    item {
                        GalaText(texto = "Cargando toda la pantalla")
                    }
                }

                uiState.showFullScreenError -> {
                   item {

                       GalaText("Mostrando erro de toda la pantalla")
                   }
                }

                uiState.showContent -> {
                    //Esto mostrará lo que es la pantalla principal, la pantalla "correcta"
                    items(uiState.appointments){
                       appointment->
                        val services=appointment.serviceSummary
                        val size=services.size
                        var serviceCardName=services[0].nombre
                        if (size>1)serviceCardName= "$serviceCardName..."

                        AppoinmentDetailCard(
                            nombreCliente = appointment.client.nombre,
                            //todo solo muestro el primer servicio
                            servicio = serviceCardName,
                            duracion = services.sumOf{
                                service ->
                                service.duracionMin
                            }.toString(),
                            horaInicio = appointment.scheduledStart,
                            mensajeBagde = appointment.appointmentStatus.toDisplayText(),
                            colorBagde =appointment.appointmentStatus.toBadgeColorBg(),
                            colorTextoBagde = appointment.appointmentStatus.toBadgeColorText(),
                            //iconButtonIcon = TODO(),
                            //iconOnClick = TODO(),
                            //modifier = TODO()
                        )
                    }
                }

                else -> {
                    if (uiState.showErrorSnackbar) {
                        //Este es un estado en el cual se muetran errores por encima de la pantalla actual, será un modal lo que se mostrará
                    }
                }
            }


            // Si está cargando por primera vez, se debe mostrar la carga completa y no la lista.
            // Si ocurrió un error inicial y aún no hay datos visibles, se debe mostrar la pantalla de error completa.
            // Si la consulta terminó correctamente pero no hay citas, se debe mostrar el estado vacío.
            // Si ninguna de esas condiciones se cumple, entonces se puede mostrar el contenido principal.

// Dentro del contenido principal, evaluar estados secundarios que no bloquean toda la pantalla.
// Si hay una recarga en curso y ya existe contenido, se debe mostrar un indicador de actualización.
// Si existe una cita seleccionada, se debe mostrar el detalle correspondiente.
// Si el usuario pidió crear una cita, se debe mostrar el sheet de creación.
// Si el usuario cierra el detalle, se debe limpiar la selección.
// Si el usuario cierra el sheet, se debe ocultar el sheet.
// Si el usuario consume el error, se debe limpiar el mensaje de error.

// La pantalla solo debe leer el UiState y reaccionar a él.
// La pantalla no debe cargar datos por sí sola ni consultar el repository.
// Las acciones del usuario deben enviarse al ViewModel mediante callbacks.
        }
    }

@Preview
@Composable
fun EmptyState(){
    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(),
            onErrorConsumed = {},
            onAppointmentUnselected = {},
            onCreateAppointmentRequested = {},
            onCreateAppointmentDismissed = {},
            onAppointmentSelected = {}
        )
    }
}
@Preview
@Composable
fun FullScreenLoading(){

    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(
                isLoading = true,
                appointments = emptyList()
            ),
            onErrorConsumed = {},
            onAppointmentUnselected = {},
            onCreateAppointmentRequested = {},
            onCreateAppointmentDismissed = {},
            onAppointmentSelected = {}
        )
    }
}
@Preview
@Composable
fun FullScreenError(){

    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(
                hasLoadedOnce = true,
                isLoading = false,
                errorMessage = "Hubo un error",
                appointments = emptyList()
            ),
            onErrorConsumed = {},
            onAppointmentUnselected = {},
            onCreateAppointmentRequested = {},
            onCreateAppointmentDismissed = {},
            onAppointmentSelected = {}
        )
    }
}




@Preview
@Composable
fun NormalState(){

    val repo= kotlinx.coroutines.runBlocking {
        FakeAppointmenRepository().getAppointments()

    }
    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(
                appointments =repo
            ),
            onErrorConsumed = {},
            onAppointmentUnselected = {},
            onCreateAppointmentRequested = {},
            onCreateAppointmentDismissed = {},
            onAppointmentSelected = {}
        )
    }
}


