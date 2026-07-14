package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drgabo.galaandroid.feature.appointments.data.local.FakeAppointmenRepository
import com.drgabo.galaandroid.feature.appointments.data.remote.AppointmentsApiFactory
import com.drgabo.galaandroid.feature.appointments.data.remote.RemoteAppointmentRepository
import com.drgabo.galaandroid.feature.auth.data.remote.AuthApi
import com.drgabo.galaandroid.feature.auth.data.remote.AuthApiFactory
import com.drgabo.galaandroid.feature.auth.data.remote.RemoteAuthRepository

@Composable
fun OwnerAgendaRoot(
    //recibir navegacipon
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {

    //El remember hace que en cada recomposición no se creen nuevas instancias, sino que se returilicen tal cual estaban
    val appointmentsApi = remember { AppointmentsApiFactory.create() }
    val authApi = remember { AuthApiFactory.create() }
    val authRepository = remember(authApi) {
        RemoteAuthRepository(
            authApi = authApi
        )
    }
    val repository = remember(authRepository, appointmentsApi) {
        RemoteAppointmentRepository(
            api = appointmentsApi,
            authRepository = authRepository
        )
    }

    //Crear la factory para el VM
    val factory = remember(repository) {
        OwnerAgendaViewModelFactory(repository)
    }

    //Ya se tiene la factory que creó el VM, ahora solo falta pedirlo para poder usarlos
    val viewModel: OwnerAgendaViewModel = viewModel(
        factory = factory
    )

    //Observar el UiState
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //hacer la carga inicial de datos
    LaunchedEffect(Unit) {
        viewModel.loadAppointments()
    }

    //conectar con la screen
    //todo decidir si mostrar summary o completa mediante if
    OwnerAgendaScreen(
        currentRoute = currentRoute,
        onNavigate = onNavigate,
        uiState = uiState,
        //Se le pasan las referencias de las funciones del VM, así sabe qué ejecutar en esa situación por su propia cuenta, no es necesario pasarle los parámetros
        onErrorConsumed = viewModel::onErrorConsumed,
        onAppointmentSelected = viewModel::onAppointmentSelected,
        onAppointmentUnselected = viewModel::onAppointmentUnselected,
        onCreateAppointmentRequested = viewModel::onCreateAppointmentRequested,
        onCreateAppointmentDismissed = viewModel::onCreateAppointmentDismissed,
        // loadAppointments = viewModel::loadAppointments
    )


}