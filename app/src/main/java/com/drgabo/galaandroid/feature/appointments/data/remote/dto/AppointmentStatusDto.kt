package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AppointmentStatusDto {
    @SerialName("pending_payment")
    PENDING,
    @SerialName("confirmed")
    CONFIRMED,
    @SerialName("cancelled")
    CANCELLED,
    @SerialName("completed")
    COMPLETED,

    @SerialName("no_show")
    NO_SHOW
}