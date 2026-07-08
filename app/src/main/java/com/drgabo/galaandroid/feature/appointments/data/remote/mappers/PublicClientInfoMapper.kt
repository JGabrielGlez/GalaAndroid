package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.PublicClientInfoDto
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentClient

fun PublicClientInfoDto.toDomain(): AppointmentClient{
    return AppointmentClient(
        id=this.id,
        nombre=this.nombre,
        telefono=this.telefono
    )
}