package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class StatusTimeLineDto(
    val confirmedAt: String? = null,
    val paidAt: String? = null,
    val cancelledAt: String? = null,
    val closedAt: String? = null,
)
