package com.drgabo.galaandroid.feature.clients.data.remote.dto

import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentStatus
import com.drgabo.galaandroid.feature.appointments.domain.models.PaymentStatus
import kotlinx.serialization.Serializable

@Serializable
data class ClientDto(
    val id: String,
    val nombre: String,
    val telefono: String,
    val email: String? = null,
    var cancelaciones: Int,
    val noShow: Int,
    val primeraVisitaAt: String,
    val ultimaVisitaAt: String,
    val appointmentCount: Int? = 0,
    val proximaCitaId: String? = null,
    val proximaCitaAt: String? = null,
    val historialReciente: List<HistorialRecienteDto>? = null,
    val ultimaCitaStatus: AppointmentStatus? = null
)
