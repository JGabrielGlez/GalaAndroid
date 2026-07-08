package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PaymentStatusDto {
    @SerialName("unpaid")
    UNPAID,

    @SerialName("partially_paid")
    PARTIALLY_PAID,

    @SerialName("failed")
    FAILED,

    @SerialName("refunded")
    REFUNDED,

    @SerialName("expired")
    EXPIRED,
    @SerialName("paid")
    PAID
}