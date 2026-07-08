package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import com.drgabo.galaandroid.feature.clients.data.remote.dto.ClientDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerAppointmentListItemDto(
    val id: String,
    val scheduledStart: String,
    val scheduledEnd: String,
    val appointmentStatus: AppointmentStatusDto,
    val paymentStatus: PaymentStatusDto,
    val amountPaid: Int,
    val remainingAmount: Int,
    val source: AppointmentSourceDto,
    val ghostFlag: Boolean,
    val client: PublicClientInfoDto? = null,
    val clientProfile: ClientDto? = null,
    val serviceSummary: List<ServiceDto>? = emptyList(),
    val paymentUrl: String? = null,
    val businessTimezone: String,
    val businessPaymentMode: BusinessPaymentMode,
    val notes: String? = null,
    val commercialStatus: CommercialStatusDto? = null,
    val paymentSummary: PaymentSummaryDto? = null,
    val statusTimeline: StatusTimeLineDto? = null
)



@Serializable
enum class BusinessPaymentMode {
    @SerialName("online")
    ONLINE,
    @SerialName("in_person")
    IN_PERSON
}
/*
*
export type OwnerAppointmentListItemDto = {
  id: string;
  scheduledStart: string;
  scheduledEnd: string;
  appointmentStatus: AppointmentStatus;
  paymentStatus: PaymentStatus;
  amountPaid: number;
  remainingAmount: number;
  source: AppointmentSource;
  ghostFlag: boolean;
  client: {
    id: string;
    nombre: string;
    telefono: string;
  };
  clientProfile?: OwnerClientListItemDto | null;
  serviceSummary?: Array<{
    serviceId?: string;
    nombre: string;
    duracionMin: number;
    precio: number;
  }>;
  paymentUrl?: string | null;
  businessTimezone?: string;
  // T-13 — modo de cobro del negocio, para que los flujos de cita (p. ej.
  // reagenda) oculten controles de pago en cobro en sitio.
  businessPaymentMode?: "online" | "in_person";
  notes?: string | null;
  commercialStatus?: CommercialStatus;
  paymentSummary?: {
    amountDue: number;
    amountPaid: number;
    remainingAmount: number;
    receiptAvailable: boolean;
  };
  statusTimeline?: {
    confirmedAt?: string | null;
    paidAt?: string | null;
    cancelledAt?: string | null;
    closedAt?: string | null;
  };
};
* */