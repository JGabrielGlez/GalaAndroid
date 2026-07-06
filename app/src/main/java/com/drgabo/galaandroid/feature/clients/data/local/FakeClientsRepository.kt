package com.drgabo.galaandroid.feature.clients.data.local

import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentStatus
import com.drgabo.galaandroid.feature.clients.domain.models.Client
import com.drgabo.galaandroid.feature.clients.domain.repositories.ClientsRepository
import com.drgabo.galaandroid.feature.clients.domain.models.HistorialRecienteDto
import com.drgabo.galaandroid.feature.appointments.domain.models.PaymentStatus


//Lista temporal de clientes (Se actualizará con los datos de la api después)
private val clientesDemo = listOf(
    Client(
        id = "client_001",
        nombre = "Gabriel Soto",
        telefono = "6141234567",
        email = "gabriel.soto@example.com",
        cancelaciones = 1,
        noShow = 0,
        primeraVisitaAt = "2026-01-10 10:00",
        ultimaVisitaAt = "2026-06-20 12:00",
        appointmentCount = 8,
        proximaCitaId = "appt_001",
        proximaCitaAt = "2026-07-01 11:00",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_001",
                scheduledStart = "2026-07-01 11:00",
                appointmentStatus = AppointmentStatus.CONFIRMED,
                paymentStatus = PaymentStatus.PENDING,
                serviceNombre = "Corte de cabello"
            ),
            HistorialRecienteDto(
                appointmentId = "appt_000",
                scheduledStart = "2026-06-20 12:00",
                appointmentStatus = AppointmentStatus.COMPLETED,
                paymentStatus = PaymentStatus.PAID,
                serviceNombre = "Barba"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    Client(
        id = "client_002",
        nombre = "Ana Lopez",
        telefono = "6142345678",
        email = "ana.lopez@example.com",
        cancelaciones = 0,
        noShow = 0,
        primeraVisitaAt = "2026-02-03 09:30",
        ultimaVisitaAt = "2026-06-18 16:00",
        appointmentCount = 5,
        proximaCitaId = "appt_002",
        proximaCitaAt = "2026-07-03 16:30",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_002",
                scheduledStart = "2026-07-03 16:30",
                appointmentStatus = AppointmentStatus.PENDING,
                paymentStatus = PaymentStatus.PENDING,
                serviceNombre = "Tinte"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    Client(
        id = "client_003",
        nombre = "Luis Ramirez",
        telefono = "6143456789",
        email = "luis.ramirez@example.com",
        cancelaciones = 2,
        noShow = 1,
        primeraVisitaAt = "2025-11-15 14:00",
        ultimaVisitaAt = "2026-06-15 10:00",
        appointmentCount = 11,
        proximaCitaId = null,
        proximaCitaAt = null,
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_003",
                scheduledStart = "2026-06-15 10:00",
                appointmentStatus = AppointmentStatus.NO_SHOW,
                paymentStatus = PaymentStatus.CANCELLED,
                serviceNombre = "Corte premium"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.NO_SHOW
    ),
    Client(
        id = "client_004",
        nombre = "Mariana Salazar",
        telefono = "6144567890",
        email = "mariana.salazar@example.com",
        cancelaciones = 1,
        noShow = 0,
        primeraVisitaAt = "2026-03-01 13:00",
        ultimaVisitaAt = "2026-06-22 18:00",
        appointmentCount = 6,
        proximaCitaId = "appt_004",
        proximaCitaAt = "2026-06-30 18:30",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_004",
                scheduledStart = "2026-06-30 18:30",
                appointmentStatus = AppointmentStatus.CONFIRMED,
                paymentStatus = PaymentStatus.PAID,
                serviceNombre = "Balayage"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    Client(
        id = "client_005",
        nombre = "Daniel Ortega",
        telefono = "6145678901",
        email = "daniel.ortega@example.com",
        cancelaciones = 3,
        noShow = 0,
        primeraVisitaAt = "2025-12-20 17:30",
        ultimaVisitaAt = "2026-06-10 17:30",
        appointmentCount = 9,
        proximaCitaId = "appt_005",
        proximaCitaAt = "2026-07-05 09:00",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_005",
                scheduledStart = "2026-07-05 09:00",
                appointmentStatus = AppointmentStatus.PENDING,
                paymentStatus = PaymentStatus.PENDING,
                serviceNombre = "Corte clasico"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.CANCELLED
    ),
    Client(
        id = "client_006",
        nombre = "Fernanda Cruz",
        telefono = "6146789012",
        email = "fernanda.cruz@example.com",
        cancelaciones = 0,
        noShow = 0,
        primeraVisitaAt = "2026-04-12 11:00",
        ultimaVisitaAt = "2026-06-24 11:00",
        appointmentCount = 4,
        proximaCitaId = "appt_006",
        proximaCitaAt = "2026-07-02 12:00",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_006",
                scheduledStart = "2026-07-02 12:00",
                appointmentStatus = AppointmentStatus.CONFIRMED,
                paymentStatus = PaymentStatus.PAID,
                serviceNombre = "Manicure"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    Client(
        id = "client_007",
        nombre = "Jorge Castillo",
        telefono = "6147890123",
        email = "jorge.castillo@example.com",
        cancelaciones = 2,
        noShow = 2,
        primeraVisitaAt = "2025-10-08 08:00",
        ultimaVisitaAt = "2026-05-29 08:00",
        appointmentCount = 13,
        proximaCitaId = null,
        proximaCitaAt = null,
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_007",
                scheduledStart = "2026-05-29 08:00",
                appointmentStatus = AppointmentStatus.CANCELLED,
                paymentStatus = PaymentStatus.REFUNDED,
                serviceNombre = "Afeitado"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.CANCELLED
    ),
    Client(
        id = "client_008",
        nombre = "Sofia Herrera",
        telefono = "6148901234",
        email = "sofia.herrera@example.com",
        cancelaciones = 0,
        noShow = 0,
        primeraVisitaAt = "2026-01-25 15:00",
        ultimaVisitaAt = "2026-06-26 15:00",
        appointmentCount = 7,
        proximaCitaId = "appt_008",
        proximaCitaAt = "2026-07-04 15:30",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_008",
                scheduledStart = "2026-07-04 15:30",
                appointmentStatus = AppointmentStatus.CONFIRMED,
                paymentStatus = PaymentStatus.PAID,
                serviceNombre = "Peinado"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    Client(
        id = "client_009",
        nombre = "Ricardo Nunez",
        telefono = "6149012345",
        email = "ricardo.nunez@example.com",
        cancelaciones = 1,
        noShow = 1,
        primeraVisitaAt = "2026-02-14 19:00",
        ultimaVisitaAt = "2026-06-12 19:00",
        appointmentCount = 3,
        proximaCitaId = "appt_009",
        proximaCitaAt = "2026-07-06 19:00",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_009",
                scheduledStart = "2026-07-06 19:00",
                appointmentStatus = AppointmentStatus.PENDING,
                paymentStatus = PaymentStatus.FAILED,
                serviceNombre = "Color completo"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    ),
    Client(
        id = "client_010",
        nombre = "Valeria Mendez",
        telefono = "6140123456",
        email = "valeria.mendez@example.com",
        cancelaciones = 0,
        noShow = 0,
        primeraVisitaAt = "2026-05-05 10:30",
        ultimaVisitaAt = "2026-06-25 10:30",
        appointmentCount = 2,
        proximaCitaId = "appt_010",
        proximaCitaAt = "2026-07-08 10:30",
        historialReciente = listOf(
            HistorialRecienteDto(
                appointmentId = "appt_010",
                scheduledStart = "2026-07-08 10:30",
                appointmentStatus = AppointmentStatus.CONFIRMED,
                paymentStatus = PaymentStatus.PAID,
                serviceNombre = "Tratamiento capilar"
            )
        ),
        ultimaCitaStatus = AppointmentStatus.COMPLETED
    )
)


class FakeClientsRepository: ClientsRepository {
    override fun getClients(): List<Client> {
        return clientesDemo
    }

    override fun getClientById(id: String): Client {
        return clientesDemo.find{
            c->
            c.id==id
        }?: throw NoSuchElementException("El cliente buscado no existe")
    }


}