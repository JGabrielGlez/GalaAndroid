package com.drgabo.galaandroid.feature.clients.presentation.showClientDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drgabo.galaandroid.feature.clients.data.local.FakeOwnerClientsListData
import com.drgabo.galaandroid.feature.clients.domain.usecases.GetOwnerClientByIdUseCase


@Composable
fun ShowClientDetailsRoot(
    currentRoute: String?,
    onNavigate: (String)-> Unit,
    clientId:String
){
    //A partir de aquí se construyen todas las dependencias que permitan conectar TODOS los archivos creados
    //Se ocupan construir el view model y el uiState

    //Se construye el repo que me da la fuente de datos
    val repository = remember{
        FakeOwnerClientsListData()
    }

    //Con esa fuente de datos, se le pasa al useCase
    val useCase = remember {
        GetOwnerClientByIdUseCase(repository)
    }

    //Después del useCase, como el vm tiene una factory para crearla, se hace uso de esa clase
    val factory = remember {
        ShowClientDetailsViewModelFactory(getClientByIdUseCase = useCase)
    }

    //Ya se tiene la factory, entonces se crea el View Model, y de este se sacará la uiState
    val viewModel: ShowClientDetailsViewModel = viewModel(factory=factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // a partir de este momento ya se le pueden enviar cosas a la Screen

    //Esto lo que hace es que cuando se compone, lo que hace es cargar el cliente, para posteriormente mandar a llamar a la screen
    LaunchedEffect(clientId) {
        viewModel.loadClient(clientId)
    }

    ShowClientDetailsScreen(
        currentRoute=currentRoute,
        onNavigate=onNavigate,
        uiState=uiState,
        //Este es el callback hacia el VM

        //Aquí debo agregar todos los callbacks hacia los métodos que aún no defino que puede hacer lo que es la screen completa, como por ejemplo, eliminar, editar, etc.
    )

}