package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class PaymentSummaryDto(
    val amountDue: Int,
    val amountPaid: Int,
    val remainingAmount: Int,
    val receiptAvailable: Boolean,
)