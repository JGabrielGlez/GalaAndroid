package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class OwnerAgendaDayDto(
    val date: String,
    val label: String,
    val appointments: List<OwnerAppointmentListItemDto>,
)
