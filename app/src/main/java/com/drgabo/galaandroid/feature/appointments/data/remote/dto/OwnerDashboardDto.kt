package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import com.drgabo.galaandroid.data.dto.OwnerBusinessSummaryDto
import com.drgabo.galaandroid.data.dto.OwnerClientListItemDto
import com.drgabo.galaandroid.data.dto.OwnerDashboardRealtimeDto
import kotlinx.serialization.Serializable

@Serializable
data class OwnerDashboardDto(
    val businessSummary: OwnerBusinessSummaryDto,
    val agendaDate: String,
    val agendaLabel: String,
    val todayStats: OwnerDashboardTodayStatsDto,
    val appointmentsPreview: List<OwnerAppointmentListItemDto>,
    val clientsPreview: List<OwnerClientListItemDto>,
    val realtime: OwnerDashboardRealtimeDto,
)

@Serializable
data class OwnerDashboardTodayStatsDto(
    val totalAppointments: Int,
    val confirmedAppointments: Int,
    val pendingAppointments: Int,
)
