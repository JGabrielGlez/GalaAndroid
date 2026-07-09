package com.drgabo.galaandroid.feature.appointments.domain.repositories

import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment


//exponer operaciones que tengan sentido para la app
interface AppointmentRepository {
    fun getAppointmens(): List<Appointment>
    fun getAppointmentById(id: String): Appointment?
    //puede no encontrar nada
    //Este debe definir lo que es el CRUD de todo,
    //definir más delante lo que son las funciones para
    //agregar, cancelar, editar un Appointment, se hará cuando se
    //construya correctamente lo que es la pantalla del FAB

}