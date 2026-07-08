package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.PaymentSummaryDto
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentPaymentSummary

fun PaymentSummaryDto.toDomain(): AppointmentPaymentSummary{
    return AppointmentPaymentSummary(
        amountDue=this.amountDue,
        amountPaid=this.amountPaid,
        remainingAmount=this.remainingAmount,
        receiptAvailable=this.receiptAvailable
    )
}