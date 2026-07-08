package com.drgabo.galaandroid.feature.appointments.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

enum class PaymentStatus {
    UNPAID,

    PARTIALLY_PAID,

    FAILED,

    REFUNDED,

    EXPIRED,
    PAID,

}