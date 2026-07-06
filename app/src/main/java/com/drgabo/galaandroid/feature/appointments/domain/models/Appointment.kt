package com.drgabo.galaandroid.feature.appointments.domain.models

data class Appointment(
    val id: String,
    val nombreCliente: String,
    val servicio: String,
    val duracion: String,
    val horaInicio: String,
    val mensajeBagde: AppointmentStatus,
    //NO debe tener cosas de UI
)