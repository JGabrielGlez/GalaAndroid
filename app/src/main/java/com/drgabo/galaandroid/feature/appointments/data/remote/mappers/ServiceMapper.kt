package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.ServiceDto
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentService


fun ServiceDto.toDomain(): AppointmentService {
    return AppointmentService(
        serviceId = this.serviceId,
        nombre = this.nombre,
        duracionMin = this.duracionMin,
        precio = this.precio
    )
}