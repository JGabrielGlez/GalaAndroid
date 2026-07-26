package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drgabo.galaandroid.feature.appointments.data.local.FakeAppointmenRepository
import com.drgabo.galaandroid.feature.clients.data.local.FakeOwnerClientsListData
import com.drgabo.galaandroid.feature.clients.domain.usecases.GetOwnerClientsUseCase
import com.drgabo.galaandroid.navigation.AppDestinations


@Composable
fun OwnerClientsRoot(
    currentRoute: String?,
    onNavigate: (String)-> Unit
){
    //Se deben de construir todas las dependencias que se van a usar para pasarlas a la screen
    val repository = remember {
        FakeOwnerClientsListData()
    }

    val useCase = remember {
        GetOwnerClientsUseCase(
            repository = repository
        )
    }

    val factory = remember {
        OwnerClientsViewModelFactory(
            getClientsUseCase = useCase
        )
    }

    val viewModel: OwnerClientsViewModel = viewModel(factory=factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //Aquí se le pasa todo a la screen
    OwnerClientsScreen(
        currentRoute=currentRoute,
        onNavigate=onNavigate,
        uiState=uiState,
        //Este es el callback hacia el VM
        onQueryChange = viewModel::onQueryChange,
        onFabClicked = viewModel::onAddClient,
        onAddClientDismissed=viewModel::onAddClientDismissed,
        onClientCardClicked = {
            clientId->
            onNavigate(
                AppDestinations.clientDetail(clientId)
            )
        }
    )


}