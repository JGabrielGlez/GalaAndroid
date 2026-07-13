package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import com.drgabo.galaandroid.feature.clients.data.remote.dto.ClientDto
import kotlinx.serialization.Serializable

@Serializable
data class OwnerDashboardDto(
    val businessSummary: OwnerBusinessSummaryDto,
    val agendaDate: String,
    val agendaLabel: String,
    val todayStats: OwnerDashboardTodayStatsDto,
    val appointmentsPreview: List<OwnerAppointmentListItemDto>,
    val clientsPreview: List<ClientDto>,
    val realtime: OwnerDashboardRealtimeDto,
)

@Serializable
data class OwnerDashboardTodayStatsDto(
    val totalAppointments: Int,
    val confirmedAppointments: Int,
    val pendingAppointments: Int,
)
