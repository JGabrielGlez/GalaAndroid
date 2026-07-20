package com.drgabo.galaandroid.feature.clients.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.mappers.toDomain
import com.drgabo.galaandroid.feature.clients.data.remote.dto.HistorialRecienteDto
import com.drgabo.galaandroid.feature.clients.domain.models.HistorialReciente

fun HistorialRecienteDto.toDomain(): HistorialReciente{
    return HistorialReciente(
        appointmentId = this.appointmentId,
        scheduledStart = this.scheduledStart,
        appointmentStatus = this.appointmentStatus.toDomain(),
        paymentStatus = this.paymentStatus.toDomain(),
        cancellationReason = this.cancellationReason?:"No se especificó una razón de cancelación",
        serviceNombre = this.serviceNombre?:"Aún no tiene servicios registrados"
        //estoy armando aquí el objeto que voy a retornar
    )
}