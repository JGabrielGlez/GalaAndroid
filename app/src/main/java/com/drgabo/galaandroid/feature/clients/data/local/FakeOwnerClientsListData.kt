package com.drgabo.galaandroid.feature.clients.data.local

import com.drgabo.galaandroid.data.domain.models.AppointmentStatus
import com.drgabo.galaandroid.data.domain.models.PaymentStatus
import com.drgabo.galaandroid.feature.clients.domain.models.HistorialReciente
import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem
import com.drgabo.galaandroid.feature.clients.domain.repositories.OwnerClientsRepository


class FakeOwnerClientsListData: OwnerClientsRepository{
    override suspend fun getClients(): Result<List<OwnerClientListItem>> {

        return Result.success(OwnerClientsList.sortedBy {
            it.nombre
        })
    }

    override suspend fun getClientById(id: String): Result<OwnerClientListItem?> {
        return Result.success(OwnerClientsList.find {
            clientListItem ->
            clientListItem.id==id
        })
    }

}


 val OwnerClientsList = listOf(
    OwnerClientListItem(
        id = "client-001",
        nombre = "Valentina Herrera",
        telefono = "+52 614 201 4587",
        email = "valentina.herrera@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2025-08-12T10:00:00Z",
        ultimaVisitaAt = "2026-07-10T16:30:00Z",
        appointmentsCount = 12,
        proximaCitaId = "appointment-001",
        proximaCitaAt = "2026-07-22T17:00:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0001",
            scheduledStart = "2026-07-10T16:30:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Corte y peinado"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-002",
        nombre = "Mateo Ramírez",
        telefono = "+52 614 218 9034",
        email = "mateo.ramirez@example.com",
        cancelaciones = 1,
        primeraVisitaAt = "2025-09-03T12:00:00Z",
        ultimaVisitaAt = "2026-07-08T11:00:00Z",
        appointmentsCount = 9,
        proximaCitaId = "appointment-002",
        proximaCitaAt = "2026-07-24T12:30:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0002",
            scheduledStart = "2026-07-08T11:00:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PARTIALLY_PAID,
            cancellationReason = "N/A",
            serviceNombre = "Barba clásica"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-003",
        nombre = "Camila Soto",
        telefono = "+52 614 226 1749",
        email = "camila.soto@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2026-01-15T09:30:00Z",
        ultimaVisitaAt = "2026-07-05T09:30:00Z",
        appointmentsCount = 6,
        proximaCitaId = "appointment-003",
        proximaCitaAt = "2026-07-21T10:00:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0003",
            scheduledStart = "2026-07-05T09:30:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Manicure gel"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-004",
        nombre = "Diego Morales",
        telefono = "+52 614 239 6821",
        email = "diego.morales@example.com",
        cancelaciones = 2,
        primeraVisitaAt = "2025-11-20T15:00:00Z",
        ultimaVisitaAt = "2026-06-30T18:00:00Z",
        appointmentsCount = 8,
        proximaCitaId = null,
        proximaCitaAt = null,
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0004",
            scheduledStart = "2026-06-30T18:00:00Z",
            appointmentStatus = AppointmentStatus.CANCELLED,
            paymentStatus = PaymentStatus.REFUNDED,
            cancellationReason = "client_exit",
            serviceNombre = "Limpieza facial"
        ),
        ultimaCitaStatus = AppointmentStatus.CANCELLED
    ),
    OwnerClientListItem(
        id = "client-005",
        nombre = "Renata González",
        telefono = "+52 614 245 3076",
        email = "renata.gonzalez@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2026-02-02T13:00:00Z",
        ultimaVisitaAt = "2026-07-12T13:00:00Z",
        appointmentsCount = 5,
        proximaCitaId = "appointment-005",
        proximaCitaAt = "2026-07-29T13:00:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0005",
            scheduledStart = "2026-07-12T13:00:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Diseño de cejas"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-006",
        nombre = "Santiago Navarro",
        telefono = "+52 614 252 8410",
        email = "santiago.navarro@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2025-07-18T17:30:00Z",
        ultimaVisitaAt = "2026-07-06T17:30:00Z",
        appointmentsCount = 18,
        proximaCitaId = "appointment-006",
        proximaCitaAt = "2026-07-20T17:30:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0006",
            scheduledStart = "2026-07-06T17:30:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Corte clásico"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-007",
        nombre = "Daniela Vega",
        telefono = "+52 614 267 1198",
        email = null,
        cancelaciones = 1,
        primeraVisitaAt = "2026-03-10T10:30:00Z",
        ultimaVisitaAt = "2026-06-25T10:30:00Z",
        appointmentsCount = 4,
        proximaCitaId = null,
        proximaCitaAt = null,
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0007",
            scheduledStart = "2026-06-25T10:30:00Z",
            appointmentStatus = AppointmentStatus.NO_SHOW,
            paymentStatus = PaymentStatus.FAILED,
            cancellationReason = "expired",
            serviceNombre = "Coloración"
        ),
        ultimaCitaStatus = AppointmentStatus.NO_SHOW
    ),
    OwnerClientListItem(
        id = "client-008",
        nombre = "Emiliano Cruz",
        telefono = "+52 614 274 5322",
        email = "emiliano.cruz@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2025-12-01T08:30:00Z",
        ultimaVisitaAt = "2026-07-02T08:30:00Z",
        appointmentsCount = 10,
        proximaCitaId = "appointment-008",
        proximaCitaAt = "2026-07-27T08:30:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0008",
            scheduledStart = "2026-07-02T08:30:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Afeitado premium"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-009",
        nombre = "Sofía Mendoza",
        telefono = "+52 614 281 7605",
        email = "sofia.mendoza@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2026-04-05T14:00:00Z",
        ultimaVisitaAt = "2026-07-09T14:00:00Z",
        appointmentsCount = 3,
        proximaCitaId = "appointment-009",
        proximaCitaAt = "2026-07-23T14:00:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0009",
            scheduledStart = "2026-07-09T14:00:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PARTIALLY_PAID,
            cancellationReason = "N/A",
            serviceNombre = "Pedicure spa"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-010",
        nombre = "Julián Torres",
        telefono = "+52 614 293 4826",
        email = "julian.torres@example.com",
        cancelaciones = 3,
        primeraVisitaAt = "2025-10-11T16:00:00Z",
        ultimaVisitaAt = "2026-06-18T16:00:00Z",
        appointmentsCount = 7,
        proximaCitaId = null,
        proximaCitaAt = null,
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0010",
            scheduledStart = "2026-06-18T16:00:00Z",
            appointmentStatus = AppointmentStatus.CANCELLED,
            paymentStatus = PaymentStatus.EXPIRED,
            cancellationReason = "owner_cancelled",
            serviceNombre = "Tratamiento capilar"
        ),
        ultimaCitaStatus = AppointmentStatus.CANCELLED
    ),
    OwnerClientListItem(
        id = "client-011",
        nombre = "Natalia Ríos",
        telefono = "+52 614 305 9174",
        email = "natalia.rios@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2026-01-28T11:30:00Z",
        ultimaVisitaAt = "2026-07-11T11:30:00Z",
        appointmentsCount = 11,
        proximaCitaId = "appointment-011",
        proximaCitaAt = "2026-07-26T11:30:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0011",
            scheduledStart = "2026-07-11T11:30:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Extensiones de pestañas"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-012",
        nombre = "Andrés Silva",
        telefono = "+52 614 317 2648",
        email = null,
        cancelaciones = 1,
        primeraVisitaAt = "2025-06-22T18:30:00Z",
        ultimaVisitaAt = "2026-06-28T18:30:00Z",
        appointmentsCount = 14,
        proximaCitaId = "appointment-012",
        proximaCitaAt = "2026-07-30T18:30:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0012",
            scheduledStart = "2026-06-28T18:30:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Corte y barba"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-013",
        nombre = "Mariana Fuentes",
        telefono = "+52 614 328 6412",
        email = "mariana.fuentes@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2026-05-14T09:00:00Z",
        ultimaVisitaAt = "2026-07-07T09:00:00Z",
        appointmentsCount = 2,
        proximaCitaId = "appointment-013",
        proximaCitaAt = "2026-07-31T09:00:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0013",
            scheduledStart = "2026-07-07T09:00:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.UNPAID,
            cancellationReason = "N/A",
            serviceNombre = "Masaje relajante"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    OwnerClientListItem(
        id = "client-014",
        nombre = "Rodrigo Castillo",
        telefono = "+52 614 339 8750",
        email = "rodrigo.castillo@example.com",
        cancelaciones = 2,
        primeraVisitaAt = "2025-09-29T13:30:00Z",
        ultimaVisitaAt = "2026-06-21T13:30:00Z",
        appointmentsCount = 6,
        proximaCitaId = null,
        proximaCitaAt = null,
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0014",
            scheduledStart = "2026-06-21T13:30:00Z",
            appointmentStatus = AppointmentStatus.CANCELLED,
            paymentStatus = PaymentStatus.REFUNDED,
            cancellationReason = "El cliente solicitó cambiar la fecha",
            serviceNombre = "Facial hidratante"
        ),
        ultimaCitaStatus = AppointmentStatus.CANCELLED
    ),
    OwnerClientListItem(
        id = "client-015",
        nombre = "Paola Villalobos",
        telefono = "+52 614 346 1089",
        email = "paola.villalobos@example.com",
        cancelaciones = 0,
        primeraVisitaAt = "2025-08-30T15:30:00Z",
        ultimaVisitaAt = "2026-07-13T15:30:00Z",
        appointmentsCount = 16,
        proximaCitaId = "appointment-015",
        proximaCitaAt = "2026-08-01T15:30:00Z",
        historialReciente = HistorialReciente(
            appointmentId = "appointment-0015",
            scheduledStart = "2026-07-13T15:30:00Z",
            appointmentStatus = AppointmentStatus.COMPLETED,
            paymentStatus = PaymentStatus.PAID,
            cancellationReason = "N/A",
            serviceNombre = "Alaciado"
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    )
)
