package com.drgabo.galaandroid.feature.clients.domain.models

import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentStatus
import com.drgabo.galaandroid.feature.appointments.domain.models.PaymentStatus


data class ClientRecentAppointment(
    val appointmentId: String,
    val scheduledStart: String,
    val appointmentStatus: AppointmentStatus,
    val paymentStatus: PaymentStatus,
    val serviceNombre: String? = null
)