package com.drgabo.galaandroid.data

data class Client(
    val id: String,
    val nombre:String,
    val telefono:String,
    val email:String? = "",
    var cancelaciones:Int,
    val noShow:Int,
    val primeraVisitaAt: String,
    val ultimaVisitaAt: String,
    val appointmentCount:Int?=0,
    val proximaCitaId:String?=null,
    val proximaCitaAt:String?=null,
    val historialReciente: List<HistorialRecienteDto>? = null,
    val ultimaCitaStatus: AppointmentStatus? = null

    )


data class HistorialRecienteDto(
    val appointmentId: String,
    val scheduledStart: String,
    val appointmentStatus: AppointmentStatus,
    val paymentStatus: PaymentStatus,
    val serviceNombre: String? = null
)