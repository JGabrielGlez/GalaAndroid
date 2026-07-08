package com.drgabo.galaandroid.feature.appointments.domain.models

class AppointmentPaymentSummary (
    val amountDue: Int,
    val amountPaid: Int,
    val remainingAmount: Int,
    val receiptAvailable: Boolean,
)