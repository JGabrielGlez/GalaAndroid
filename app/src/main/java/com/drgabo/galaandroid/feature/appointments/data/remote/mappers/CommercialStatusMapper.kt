package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.CommercialStatusDto
import com.drgabo.galaandroid.feature.appointments.domain.models.CommercialStatus

fun CommercialStatusDto.toDomain(): CommercialStatus {
    return when (this) {
        CommercialStatusDto.SETUP -> CommercialStatus.SETUP
        CommercialStatusDto.PENDING_ACTIVATION -> CommercialStatus.PENDING_ACTIVATION
        CommercialStatusDto.TRIALING -> CommercialStatus.TRIALING
        CommercialStatusDto.ACTIVE -> CommercialStatus.ACTIVE
        CommercialStatusDto.PAST_DUE -> CommercialStatus.PAST_DUE
        CommercialStatusDto.SUSPENDED -> CommercialStatus.SUSPENDED
    }
}
