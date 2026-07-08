package com.drgabo.galaandroid.feature.appointments.domain.models


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
    val client: AppointmentClient? = null,
    //val clientProfile: ClientDto? = null,
    val serviceSummary: List<AppointmentService>? = emptyList(),
    val paymentUrl: String? = null,
    //val businessTimezone: String,
    //val businessPaymentMode: BusinessPaymentMode,
    val notes: String? = null,
    //val commercialStatus: CommercialStatus? = null,
    val paymentSummary: AppointmentPaymentSummary? = null,
    //val statusTimeline: StatusTimeLine? = null
)

