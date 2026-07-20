package com.drgabo.galaandroid.feature.clients.data.remote.dto

import com.drgabo.galaandroid.data.enums.AppointmentStatusDto
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

/*
*
export type OwnerClientListItemDto = {
    id: string;
    nombre: string;
    telefono: string;
    email?: string | null;
    cancelaciones: number;
    noShows: number;
    primeraVisitaAt: string;
    ultimaVisitaAt: string;
    appointmentsCount?: number;
    proximaCitaId?: string | null;
    proximaCitaAt?: string | null;
    historialReciente?: Array<{
        appointmentId: string;
        scheduledStart: string;
        appointmentStatus: AppointmentStatus;
        paymentStatus: PaymentStatus;
        cancellationReason?: CancellationReason | null;
        serviceNombre?: string;
    }>;
    ultimaCitaStatus?: AppointmentStatus | null;
};*/