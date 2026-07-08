package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CommercialStatusDto {
    @SerialName("setup")
    SETUP,
    @SerialName("pending_activation")
    PENDING_ACTIVATION,
    @SerialName("trialing")
    TRIALING,
    @SerialName("active")
    ACTIVE,
    @SerialName("past_due")
    PAST_DUE,
    @SerialName("suspended")
    SUSPENDED,
}