package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.OwnerAgendaDayDto
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerAgendaDay

fun OwnerAgendaDayDto.toDomain(): OwnerAgendaDay {
    return OwnerAgendaDay(
        date = this.date,
        label = this.label,
        appointments = this.appointments.map { appointment ->
            appointment.toDomain()
        },
    )
}
