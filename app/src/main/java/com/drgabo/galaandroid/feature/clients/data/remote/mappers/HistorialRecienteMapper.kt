package com.drgabo.galaandroid.feature.clients.data.remote.mappers

import com.drgabo.galaandroid.feature.clients.data.remote.dto.HistorialRecienteDto
import com.drgabo.galaandroid.feature.clients.domain.models.ClientRecentAppointment

fun HistorialRecienteDto.toDomain(): ClientRecentAppointment {
    return ClientRecentAppointment(
        appointmentId = this.appointmentId,
        scheduledStart = this.scheduledStart,
        appointmentStatus = this.appointmentStatus,
        paymentStatus = this.paymentStatus,
        serviceNombre = this.serviceNombre,
    )
}
