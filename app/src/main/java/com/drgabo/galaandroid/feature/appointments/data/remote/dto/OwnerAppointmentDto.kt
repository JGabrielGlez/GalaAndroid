package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*
En la api se recibe todo esto debido a que la pantalla en sí contiene toda
esta información, es la información que se ve en la tab de Inicio
*/
@Serializable
data class OwnerAppointmentsResponseDto(
    val businessSummary: OwnerBusinessSummaryDto,
    val agendaDate: String,
    val agendaLabel: String,
    val appointments: List<OwnerAppointmentListItemDto>,
    val selectedAppointment: OwnerAppointmentListItemDto? = null,
    val realtime: OwnerDashboardRealtimeDto,
)


@Serializable
enum class ThemeId {
    neutral,
    estetica,
    barberia,

    //Este viene con "-" por defecto de JS para tenerlo en cuenta
    @SerialName("barberia-laton")
    barberia_laton,
    salud
}