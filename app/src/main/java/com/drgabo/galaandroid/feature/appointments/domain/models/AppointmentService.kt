package com.drgabo.galaandroid.feature.appointments.domain.models

data class AppointmentService (
    val serviceId: String? = null,
    val nombre: String,
    val duracionMin: Int,
    val precio: Int,
)