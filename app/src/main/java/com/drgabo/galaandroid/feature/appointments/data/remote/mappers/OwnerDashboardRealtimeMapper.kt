package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.data.dto.OwnerDashboardRealtimeDto
import com.drgabo.galaandroid.data.domain.models.OwnerDashboardRealtime

fun OwnerDashboardRealtimeDto.toDomain(): OwnerDashboardRealtime {
    return OwnerDashboardRealtime(
        supported = this.supported,
        channel = this.channel,
        fallbackPollingIntervalMs = this.fallbackPollingIntervalMs,
        publicationStrategy = this.publicationStrategy,
    )
}
