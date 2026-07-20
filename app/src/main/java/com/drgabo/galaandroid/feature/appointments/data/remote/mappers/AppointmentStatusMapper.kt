package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.data.enums.AppointmentStatusDto
import com.drgabo.galaandroid.data.domain.models.AppointmentStatus


fun AppointmentStatusDto.toDomain(): AppointmentStatus{
    return when (this){
        AppointmentStatusDto.CANCELLED->AppointmentStatus.CANCELLED
        AppointmentStatusDto.COMPLETED->AppointmentStatus.COMPLETED
        AppointmentStatusDto.CONFIRMED->AppointmentStatus.CONFIRMED
        AppointmentStatusDto.NO_SHOW->AppointmentStatus.NO_SHOW
        AppointmentStatusDto.PENDING->AppointmentStatus.PENDING
    }
}