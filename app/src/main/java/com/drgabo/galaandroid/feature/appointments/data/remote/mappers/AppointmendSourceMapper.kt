package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.AppointmentSourceDto
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentSource


fun AppointmentSourceDto.toDomain(): AppointmentSource{
    return when (this){
        AppointmentSourceDto.MANUAL_OWNER-> AppointmentSource.MANUAL_OWNER
        AppointmentSourceDto.PUBLIC_BOOKING->AppointmentSource.PUBLIC_BOOKING
        AppointmentSourceDto.GHOST_BLOCK->AppointmentSource.GHOST_BLOCK
    }

}