package com.drgabo.galaandroid.feature.clients.presentation.showClientDetails

import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem

sealed interface ShowClientDetailsUiState{
    data object Loading: ShowClientDetailsUiState
    data object Empty: ShowClientDetailsUiState

    data class Error(
        val message : String
    ): ShowClientDetailsUiState

    data class Success(
        //Al estar success es porque se dio click y por ende, se tiene información de lo que es el cliente como tal, sin riesgo de que sea nulo
        val client: OwnerClientListItem
    )
}

