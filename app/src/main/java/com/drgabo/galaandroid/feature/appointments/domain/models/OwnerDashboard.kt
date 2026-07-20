package com.drgabo.galaandroid.feature.appointments.domain.models

import com.drgabo.galaandroid.data.domain.models.OwnerBusinessSummary
import com.drgabo.galaandroid.data.domain.models.OwnerDashboardRealtime

data class OwnerDashboard(
    val businessSummary: OwnerBusinessSummary,
    val agendaDate: String,
    val agendaLabel: String,
    val todayStats: OwnerDashboardTodayStats,
    val appointmentsPreview: List<Appointment>,
    val clientsPreview: List<Client>,
    val realtime: OwnerDashboardRealtime,
)
