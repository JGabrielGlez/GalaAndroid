package com.drgabo.galaandroid.feature.appointments.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

enum class AppointmentStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    COMPLETED,

    NO_SHOW,

}