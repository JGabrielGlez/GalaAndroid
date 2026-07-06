package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drgabo.galaandroid.feature.clients.data.local.FakeClientsRepository

@Composable
fun OwnerClientsRoot(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    // Esta funcion conecta datos y ViewModel; no pinta la pantalla directamente.
    val repository = remember { FakeClientsRepository() }
    val factory = remember {
        OwnerClientsViewModelFactory(repository)
    }
    val viewModel: OwnerClientsViewModel = viewModel(factory = factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadClients()
    }

    OwnerClientsScreen(
        currentRoute = currentRoute,
        onNavigate = onNavigate,
        uiState = uiState,
        onQueryChange = viewModel::onQueryChange
    )
}
