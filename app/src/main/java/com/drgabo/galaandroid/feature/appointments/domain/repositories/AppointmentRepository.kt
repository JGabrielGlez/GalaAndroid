package com.drgabo.galaandroid.feature.appointments.domain.repositories

interface AppointmentRepository {
    fun getAppointmens();
    fun getAppointmentById(id: String);
    //Este debe definir lo que es el CRUD de todo
}