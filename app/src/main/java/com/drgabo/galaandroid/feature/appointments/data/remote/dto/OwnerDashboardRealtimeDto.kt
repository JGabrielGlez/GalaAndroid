package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class OwnerDashboardRealtimeDto(
    val supported: Boolean,
    val channel: String,
    val fallbackPollingIntervalMs: Int,
    val publicationStrategy: String = "supabase_realtime_then_polling",
)