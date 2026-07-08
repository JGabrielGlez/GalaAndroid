package com.drgabo.galaandroid.feature.clients.data.remote.dto

import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentStatus
import com.drgabo.galaandroid.feature.appointments.domain.models.PaymentStatus
import kotlinx.serialization.Serializable


    @Serializable
    data class HistorialRecienteDto(
        val appointmentId: String,
        val scheduledStart: String,
        val appointmentStatus: AppointmentStatus,
        val paymentStatus: PaymentStatus,
        val serviceNombre: String? = null
    )