package com.drgabo.galaandroid.feature.appointments.domain.models

import com.drgabo.galaandroid.feature.clients.domain.models.Client

data class OwnerDashboard(
    val businessSummary: OwnerBusinessSummary,
    val agendaDate: String,
    val agendaLabel: String,
    val todayStats: OwnerDashboardTodayStats,
    val appointmentsPreview: List<Appointment>,
    val clientsPreview: List<Client>,
    val realtime: OwnerDashboardRealtime,
)
