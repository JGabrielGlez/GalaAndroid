package com.drgabo.galaandroid.feature.appointments.domain.models

data class OwnerAgendaDay(
    val date: String,
    val label: String,
    val appointments: List<Appointment>,
)
