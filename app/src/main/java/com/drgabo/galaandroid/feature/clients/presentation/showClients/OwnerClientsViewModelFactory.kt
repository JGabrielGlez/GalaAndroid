package com.drgabo.galaandroid.feature.clients.presentation.showClients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drgabo.galaandroid.feature.clients.domain.usecases.GetOwnerClientsUseCase


class OwnerClientsViewModelFactory(
    //!. La factory recibe las dependencias que requiere el VM
    private val getClientsUseCase: GetOwnerClientsUseCase

): ViewModelProvider.Factory{
    //se sobreescribe la función de create
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //Se comprueba que la clase solicitada sea realmente el VM esperado
        if(modelClass.isAssignableFrom(OwnerClientsViewModel::class.java)){
            //se construye el VM con sus respectivas dependencias
            return OwnerClientsViewModel(
                getClientsUseCase = getClientsUseCase
            ) as T
        }

        //Si la factory llega a desconocer lo que recibió, se retorna un error

        throw IllegalArgumentException("ViewModel Desconocido: ${modelClass.name}")
    }
}