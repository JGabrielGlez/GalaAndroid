package com.drgabo.galaandroid.feature.appointments.domain.models

data class OwnerDashboardRealtime(
    val supported: Boolean,
    val channel: String,
    val fallbackPollingIntervalMs: Int,
    val publicationStrategy: String,
)
