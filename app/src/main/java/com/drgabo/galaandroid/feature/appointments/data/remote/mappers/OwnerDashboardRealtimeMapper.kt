package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.OwnerDashboardRealtimeDto
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerDashboardRealtime

fun OwnerDashboardRealtimeDto.toDomain(): OwnerDashboardRealtime {
    return OwnerDashboardRealtime(
        supported = this.supported,
        channel = this.channel,
        fallbackPollingIntervalMs = this.fallbackPollingIntervalMs,
        publicationStrategy = this.publicationStrategy,
    )
}
