package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.OwnerDashboardDto
import com.drgabo.galaandroid.feature.appointments.data.remote.dto.OwnerDashboardTodayStatsDto
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerDashboard
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerDashboardTodayStats
import com.drgabo.galaandroid.feature.clients.data.remote.mappers.toDomain

fun OwnerDashboardDto.toDomain(): OwnerDashboard {
    return OwnerDashboard(
        businessSummary = this.businessSummary.toDomain(),
        agendaDate = this.agendaDate,
        agendaLabel = this.agendaLabel,
        todayStats = this.todayStats.toDomain(),
        appointmentsPreview = this.appointmentsPreview.map { appointment ->
            appointment.toDomain()
        },
        clientsPreview = this.clientsPreview.map { client ->
            client.toDomain()
        },
        realtime = this.realtime.toDomain(),
    )
}

fun OwnerDashboardTodayStatsDto.toDomain(): OwnerDashboardTodayStats {
    return OwnerDashboardTodayStats(
        totalAppointments = this.totalAppointments,
        confirmedAppointments = this.confirmedAppointments,
        pendingAppointments = this.pendingAppointments,
    )
}
