package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import com.drgabo.galaandroid.core.util.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.R
import com.drgabo.galaandroid.core.ui.components.AppoinmentDetailCard
import com.drgabo.galaandroid.core.ui.components.FullScreenModal
import com.drgabo.galaandroid.core.ui.components.GalaButton
import com.drgabo.galaandroid.core.ui.components.GalaText
import com.drgabo.galaandroid.core.ui.components.ScaffoldPrincipal
import com.drgabo.galaandroid.core.ui.components.SummaryCardsRow
import com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.core.ui.theme.MonstserratFamily
import com.drgabo.galaandroid.core.ui.theme.TextoSecundario
import com.drgabo.galaandroid.core.ui.theme.Typography
import com.drgabo.galaandroid.feature.appointments.data.local.FakeAppointmenRepository
import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment

import com.drgabo.galaandroid.navigation.AppDestinations
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


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

        // Evaluar primero los estados bloqueantes, porque impiden mostrar el contenido normal de la pantalla. Aquellos estados que son mutuamente excluyentes, es decir, no pueden existir dos al mismo tiempo, solo uno debe de mostrarse
        when {
            uiState.showEmptyState -> {

                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(32.dp),

                        ) {
                        Box(
                            modifier = Modifier.size(128.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.calendar),
                                contentDescription = "Calendario",
                                modifier = Modifier.fillMaxSize(),
                                tint = TextoSecundario
                            )
                        }
                        GalaText(
                            texto =
                                "Por el momento no hay citas para el día de hoy, agenda una.",
                            textoCentrado = true,
                            peso = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth(.7f)

                        )
                        GalaButton(
                            onClick = {},
                            text = "Agendar cita",
                            isPrimary = true,
                            modifier = Modifier.fillMaxWidth(.6f)


                        )

                    }
                }
            }

            uiState.showFullScreenLoading -> {
                //mostrar que toda la pantalla está cargando
                item {
                    FullScreenModal(message="Cargando las citas del día.",
                        modifier = Modifier.fillParentMaxSize()
                    )
                }
            }

            uiState.showFullScreenError -> {
                item {

                    GalaText("Mostrando erro de toda la pantalla")
                }
            }

            uiState.showContent -> {
               // item { SummaryCardsRow() }
                uiState.agendaDays.forEach { day ->
                    //Este es el separador que me dice de qué día es la cita
                    item {
                        GalaText(
                            texto = day.label.replaceFirstChar { it.uppercase() },
                            estilo = Typography.bodyLarge,
                            peso = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    }
                    items(day.appointments){appointment->
                        val services = appointment.serviceSummary
                        val serviceName = services[0].nombre
                        val serviceCardName = if(services.size==1) serviceName else
                            "$serviceName..."
                        AppoinmentDetailCard(
                            nombreCliente = appointment.client.nombre,
                            servicio = serviceCardName,
                            duracion = services.sumOf { it.duracionMin }.toString()+" min.",
                            horaInicio = formatScheduledStartHour(appointment.scheduledStart),
                            mensajeBagde = appointment.appointmentStatus.toDisplayText(),
                            colorBagde = appointment.appointmentStatus.toBadgeColorBg(),
                            colorTextoBagde = appointment.appointmentStatus.toBadgeColorText(),
                            modifier = Modifier.fillMaxWidth()
                            //iconButtonIcon = TODO(),
                            //iconOnClick = TODO(),
                            //modifier = TODO()
                        )
                    }
                }
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


@Preview
@Composable
fun EmptyState() {
    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(
                agendaDays = emptyList(),
                isLoading = false,
                errorMessage = null,
                hasLoadedOnce = true
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
fun FullScreenLoading() {

    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(
                isLoading = true,
                agendaDays = emptyList()
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
fun FullScreenError() {

    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(
                hasLoadedOnce = true,
                isLoading = false,
                errorMessage = "Hubo un error",
                agendaDays = emptyList()
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
fun NormalState() {

    val repo = kotlinx.coroutines.runBlocking {
        FakeAppointmenRepository().getAgendaDays()

    }
    GalaAndroidTheme {
        OwnerAgendaScreen(
            currentRoute = AppDestinations.OWNER_AGENDA,
            onNavigate = {},
            uiState = OwnerAgendaUiState(
                agendaDays = repo
            ),
            onErrorConsumed = {},
            onAppointmentUnselected = {},
            onCreateAppointmentRequested = {},
            onCreateAppointmentDismissed = {},
            onAppointmentSelected = {}
        )
    }
}


