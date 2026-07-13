package com.drgabo.galaandroid.feature.appointments.domain.repositories

import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerAgendaDay


//exponer operaciones que tengan sentido para la app
interface AppointmentRepository {
     suspend fun getAgendaDays(): List<OwnerAgendaDay>

     suspend fun getAppointments(): List<Appointment>

    //no puede retornar nulo porque es una cita de una lista
    //que ya se cargó, por lo que es imposible pedir una que
    //no exista, aparte no se borran como tal de la bd

     //no es suspend porque consultará los datos que ya fueron traidos de la api
     fun getAppointmentById(id: String): Appointment
    //puede no encontrar nada
    //Este debe definir lo que es el CRUD de todo,
    //definir más delante lo que son las funciones para
    //agregar, cancelar, editar un Appointment, se hará cuando se
    //construya correctamente lo que es la pantalla del FAB

}
