package com.drgabo.galaandroid.feature.appointments.domain.models

import com.drgabo.galaandroid.data.domain.models.OwnerBusinessSummary
import com.drgabo.galaandroid.data.domain.models.OwnerDashboardRealtime
import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem

data class OwnerDashboard(
    val businessSummary: OwnerBusinessSummary,
    val agendaDate: String,
    val agendaLabel: String,
    val todayStats: OwnerDashboardTodayStats,
    val appointmentsPreview: List<Appointment>,
    val clientsPreview: List<OwnerClientListItem>,
    val realtime: OwnerDashboardRealtime,
)
