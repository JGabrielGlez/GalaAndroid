package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drgabo.galaandroid.feature.appointments.domain.repositories.AppointmentRepository
//Responsabilidades de este archivo:
/*
* 1. Recibir AppointmentRepository
* 2. Reconocer OwnerAgendaViewModel
* 3. Construirlo con el repository
* */


class OwnerAgendaViewModelFactory(
    //recibe el repositorio con el que va a retornar el ViewModel para construirlo, esto es para desacoplar la responsabilidad y no tener que construirlo dentro del propio VM, usando directamente ya sea el FakeRepo o el Repo definitivo
    private val appointmentRepository: AppointmentRepository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ):T{
        //Esto es para verificar que realmente se haya recibido una clase que es mi VM creada
        if(modelClass.isAssignableFrom(OwnerAgendaViewModel::class.java))
            //Kotlin no puede verificar correctamente en tiempo de ejecución que lo entregado sea el VM que se necesita, para eso es la validación anterior
          return  OwnerAgendaViewModel(appointmentRepository) as T
        throw IllegalArgumentException("ViewModel desconocido")
    }
}