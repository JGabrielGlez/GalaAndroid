package com.drgabo.galaandroid.feature.appointments.presentation.agenda.showAgenda

import androidx.compose.ui.graphics.Color
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentStatus
import com.drgabo.galaandroid.core.ui.theme.*

fun AppointmentStatus.toDisplayText(): String {
    return when (this){

        AppointmentStatus.CANCELLED -> "Cancelada"
        AppointmentStatus.CONFIRMED->"Confirmada"
        AppointmentStatus.NO_SHOW -> "No asistió"
        AppointmentStatus.PENDING->"Pendiente de pago"
        AppointmentStatus.COMPLETED -> "Completada"
    }
}

fun AppointmentStatus.toBadgeColorBg(): Color{
    return when (this){
        AppointmentStatus.CANCELLED -> EstadoCanceladaFondo
        AppointmentStatus.CONFIRMED->EstadoConfirmadaFondo
        AppointmentStatus.NO_SHOW -> EstadoCanceladaFondo
        AppointmentStatus.PENDING->EstadoPendienteFondo
        AppointmentStatus.COMPLETED -> EstadoCompletadaFondo
    }
}


fun AppointmentStatus.toBadgeColorText(): Color{
    return when (this){
        AppointmentStatus.CANCELLED -> EstadoCancelada
        AppointmentStatus.CONFIRMED->EstadoConfirmada
        AppointmentStatus.NO_SHOW -> EstadoCancelada
        AppointmentStatus.PENDING->EstadoPendiente
        AppointmentStatus.COMPLETED -> EstadoCompletada
    }
}
