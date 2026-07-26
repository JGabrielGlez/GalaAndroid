package com.drgabo.galaandroid.data.dto

import com.drgabo.galaandroid.data.enums.AppointmentStatusDto
import com.drgabo.galaandroid.feature.clients.data.remote.dto.HistorialRecienteDto
import kotlinx.serialization.Serializable

@Serializable
data class OwnerClientListItemDto(
    val id: String,
    val nombre: String,
    val telefono: String,
    val email: String? = null,
    val cancelaciones:Int,
    val primeraVisitaAt:String,
    val ultimaVisitaAt:String,
    val appointmentsCount:Int?=null,
    val proximaCitaId:String?=null,
    val proximaCitaAt:String?=null,
    val historialReciente: HistorialRecienteDto?=null,
    val ultimaCitaStatus: AppointmentStatusDto?=null
    )