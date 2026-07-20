package com.drgabo.galaandroid.feature.clients.data.remote.dto

import com.drgabo.galaandroid.data.enums.AppointmentStatusDto
import com.drgabo.galaandroid.data.enums.PaymentStatusDto
import kotlinx.serialization.Serializable

@Serializable
data class HistorialRecienteDto(
    val appointmentId:String,
    val scheduledStart:String,
    val appointmentStatus: AppointmentStatusDto,
    val paymentStatus: PaymentStatusDto,
    val cancellationReason: String?=null,
    val serviceNombre:String?=null
)
/*
*       appointmentId: string;
        scheduledStart: string;
        appointmentStatus: AppointmentStatus;
        paymentStatus: PaymentStatus;
        cancellationReason?: CancellationReason | null;
        serviceNombre?: string;
* */