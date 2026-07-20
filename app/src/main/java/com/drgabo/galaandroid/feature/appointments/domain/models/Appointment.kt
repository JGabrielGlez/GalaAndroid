package com.drgabo.galaandroid.feature.appointments.domain.models

import com.drgabo.galaandroid.data.domain.models.AppointmentStatus
import com.drgabo.galaandroid.data.domain.models.PaymentStatus


data class Appointment(
    val id: String,
    val scheduledStart: String,
    val scheduledEnd: String,
    val appointmentStatus: AppointmentStatus,
    val paymentStatus: PaymentStatus,
    val amountPaid: Int,
    val remainingAmount: Int,
    val source: AppointmentSource,
    val ghostFlag: Boolean,
    val client: AppointmentClient,
    //val clientProfile: ClientDto? = null,
    val serviceSummary: List<AppointmentService>,
    val paymentUrl: String,
    //val businessTimezone: String,
    //val businessPaymentMode: BusinessPaymentMode,
    val notes: String,
    //val commercialStatus: CommercialStatus? = null,
    val paymentSummary: AppointmentPaymentSummary,
    //val statusTimeline: StatusTimeLine? = null
)

