package com.drgabo.galaandroid.feature.appointments.domain.models

data class OwnerDashboardTodayStats(
    val totalAppointments: Int,
    val confirmedAppointments: Int,
    val pendingAppointments: Int,
)
