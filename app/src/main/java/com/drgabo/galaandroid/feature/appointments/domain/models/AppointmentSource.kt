package com.drgabo.galaandroid.feature.appointments.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AppointmentSource{
    @SerialName("public_booking")
    PUBLIC_BOOKING,

    @SerialName("manual_owner")
    MANUAL_OWNER,

    @SerialName("ghost_block")
    GHOST_BLOCK
}
