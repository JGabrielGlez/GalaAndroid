package com.drgabo.galaandroid.feature.clients.domain.models

import com.drgabo.galaandroid.data.domain.models.AppointmentStatus
import com.drgabo.galaandroid.data.domain.models.PaymentStatus


data class HistorialReciente(
    val appointmentId:String,
    val scheduledStart:String,
    val appointmentStatus: AppointmentStatus,
    val paymentStatus: PaymentStatus,
    val cancellationReason:String,
    val serviceNombre:String
)