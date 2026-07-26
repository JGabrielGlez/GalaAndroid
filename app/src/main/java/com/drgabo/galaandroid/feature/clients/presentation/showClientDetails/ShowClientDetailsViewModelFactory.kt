package com.drgabo.galaandroid.feature.clients.presentation.showClientDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drgabo.galaandroid.feature.clients.domain.usecases.GetOwnerClientByIdUseCase


class ShowClientDetailsViewModelFactory(
    //Recibe las dependencias que el VM requiere
    private val getClientByIdUseCase: GetOwnerClientByIdUseCase
) : ViewModelProvider.Factory {
    //Se sobreescribe la función de create
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //Se verifica que realmente se reciba un VM del tipo esperado
        if (modelClass.isAssignableFrom(ShowClientDetailsViewModel::class.java))
        //Se construye lo que es el vm con sus dependencias
            return ShowClientDetailsViewModel(getOwnerClientUseCase = getClientByIdUseCase) as T
        //Si no se recibe lo que se esperaba, se lanza un error
        throw IllegalArgumentException("ViewModel Desconocido: ${modelClass.name}")

    }
}