package com.drgabo.galaandroid.feature.clients.presentation.showClientDetails

import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem

sealed interface ShowClientDetailsUiState{
    data object Loading: ShowClientDetailsUiState

    //Este se conserva solo para un caso edge en el cual se cargue dato en caché, pero que al momento de consultarlo nuevamente, ya no existe, aunque es de ver cómo es que realmente funciona, ya que quizá sea un estado innecesario
    //data object Empty: ShowClientDetailsUiState

    data class Error(
        val message : String
    ): ShowClientDetailsUiState

    data class Success(
        //Al estar success es porque se dio click y por ende, se tiene información de lo que es el cliente como tal, sin riesgo de que sea nulo
        val client: OwnerClientListItem
    ): ShowClientDetailsUiState
}

