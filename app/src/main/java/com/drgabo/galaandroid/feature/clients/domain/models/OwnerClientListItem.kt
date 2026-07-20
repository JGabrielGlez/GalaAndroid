package com.drgabo.galaandroid.feature.clients.domain.models

import com.drgabo.galaandroid.data.domain.models.AppointmentStatus


data class OwnerClientListItem(
    val id: String,
    val nombre: String,
    val telefono: String,
    val email: String? = null,
    val cancelaciones:Int,
    val primeraVisitaAt:String,
    val ultimaVisitaAt:String,
    val appointmentsCount:Int,//se mapeará a 0
    val proximaCitaId:String?=null,
    val proximaCitaAt:String?=null,
    val historialReciente: HistorialReciente?=null,
    val ultimaCitaStatus: AppointmentStatus?=null
)
