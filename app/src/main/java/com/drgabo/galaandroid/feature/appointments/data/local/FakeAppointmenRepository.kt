    package com.drgabo.galaandroid.feature.appointments.data.local

import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentClient
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentPaymentSummary
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentService
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerAgendaDay
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentSource
import com.drgabo.galaandroid.feature.appointments.domain.models.AppointmentStatus
import com.drgabo.galaandroid.feature.appointments.domain.models.PaymentStatus
import com.drgabo.galaandroid.feature.appointments.domain.repositories.AppointmentRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class FakeAppointmenRepository : AppointmentRepository {
    override suspend fun getAgendaDays(): List<OwnerAgendaDay> {
        return appointmentsDemo
            .groupBy { appointment ->
                appointment.scheduledStart.substringBefore(" ")
            }
            .toSortedMap()
            .map { (date, appointments) ->
                val localDate = LocalDate.parse(date)
                OwnerAgendaDay(
                    date = date,
                    label = localDate.format(
                        DateTimeFormatter.ofPattern(
                            "EEEE, d 'de' MMMM",
                            Locale("es", "MX")
                        )
                    ),
                    appointments = appointments,
                )
            }
    }

    override suspend fun getAppointments(): List<Appointment> {
        return appointmentsDemo
    }

    override fun getAppointmentById(id: String): Appointment {
        return appointmentsDemo.find { cita ->
            cita.id == id
        } ?: throw NoSuchElementException(
            "La cita buscada no se encuentra disponible"
        )
    }

}

private val appointmentsDemo = listOf(
    Appointment(
        id = "appt_001",
        scheduledStart = "2026-07-14 09:00",
        scheduledEnd = "2026-07-14 10:00",
        appointmentStatus = AppointmentStatus.CONFIRMED,
        paymentStatus = PaymentStatus.PAID,
        amountPaid = 350,
        remainingAmount = 0,
        source = AppointmentSource.PUBLIC_BOOKING,
        ghostFlag = false,
        client = AppointmentClient("client_001", "Gabriel Soto", "6141234567"),
        serviceSummary = listOf(
            AppointmentService("srv_001", "Corte clasico", 60, 350)
        ),
        paymentUrl = "",
        notes = "Cliente frecuente.",
        paymentSummary = AppointmentPaymentSummary(350, 350, 0, true)
    ),
    Appointment(
        id = "appt_002",
        scheduledStart = "2026-07-14 11:00",
        scheduledEnd = "2026-07-14 12:30",
        appointmentStatus = AppointmentStatus.PENDING,
        paymentStatus = PaymentStatus.UNPAID,
        amountPaid = 0,
        remainingAmount = 500,
        source = AppointmentSource.MANUAL_OWNER,
        ghostFlag = false,
        client = AppointmentClient("client_002", "Ana Lopez", "6142345678"),
        serviceSummary = listOf(
            AppointmentService("srv_002", "Tinte", 90, 500)
        ),
        paymentUrl = "https://gala.test/pay/appt_002",
        notes = "Primera cita de color.",
        paymentSummary = AppointmentPaymentSummary(500, 0, 500, false)
    ),
    Appointment(
        id = "appt_003",
        scheduledStart = "2026-07-14 17:00",
        scheduledEnd = "2026-07-14 18:00",
        appointmentStatus = AppointmentStatus.COMPLETED,
        paymentStatus = PaymentStatus.PAID,
        amountPaid = 300,
        remainingAmount = 0,
        source = AppointmentSource.PUBLIC_BOOKING,
        ghostFlag = false,
        client = AppointmentClient("client_003", "Luis Ramirez", "6143456789"),
        serviceSummary = listOf(
            AppointmentService("srv_003", "Barba", 60, 300)
        ),
        paymentUrl = "",
        notes = "Servicio terminado sin incidencias.",
        paymentSummary = AppointmentPaymentSummary(300, 300, 0, true)
    ),
    Appointment(
        id = "appt_004",
        scheduledStart = "2026-07-15 09:30",
        scheduledEnd = "2026-07-15 11:00",
        appointmentStatus = AppointmentStatus.CONFIRMED,
        paymentStatus = PaymentStatus.PARTIALLY_PAID,
        amountPaid = 200,
        remainingAmount = 250,
        source = AppointmentSource.PUBLIC_BOOKING,
        ghostFlag = false,
        client = AppointmentClient("client_004", "Mariana Salazar", "6144567890"),
        serviceSummary = listOf(
            AppointmentService("srv_004", "Balayage", 90, 450)
        ),
        paymentUrl = "https://gala.test/pay/appt_004",
        notes = "Anticipo pagado.",
        paymentSummary = AppointmentPaymentSummary(450, 200, 250, false)
    ),
    Appointment(
        id = "appt_005",
        scheduledStart = "2026-07-15 12:00",
        scheduledEnd = "2026-07-15 13:00",
        appointmentStatus = AppointmentStatus.CANCELLED,
        paymentStatus = PaymentStatus.REFUNDED,
        amountPaid = 400,
        remainingAmount = 0,
        source = AppointmentSource.MANUAL_OWNER,
        ghostFlag = false,
        client = AppointmentClient("client_005", "Daniel Ortega", "6145678901"),
        serviceSummary = listOf(
            AppointmentService("srv_005", "Corte premium", 60, 400)
        ),
        paymentUrl = "",
        notes = "Cancelada con devolución completa.",
        paymentSummary = AppointmentPaymentSummary(400, 400, 0, true)
    ),
    Appointment(
        id = "appt_006",
        scheduledStart = "2026-07-15 18:00",
        scheduledEnd = "2026-07-15 19:30",
        appointmentStatus = AppointmentStatus.CONFIRMED,
        paymentStatus = PaymentStatus.PAID,
        amountPaid = 550,
        remainingAmount = 0,
        source = AppointmentSource.PUBLIC_BOOKING,
        ghostFlag = false,
        client = AppointmentClient("client_006", "Fernanda Cruz", "6146789012"),
        serviceSummary = listOf(
            AppointmentService("srv_006", "Manicure y gel", 90, 550)
        ),
        paymentUrl = "",
        notes = "Llega puntual.",
        paymentSummary = AppointmentPaymentSummary(550, 550, 0, true)
    ),
    Appointment(
        id = "appt_007",
        scheduledStart = "2026-07-16 08:30",
        scheduledEnd = "2026-07-16 09:30",
        appointmentStatus = AppointmentStatus.NO_SHOW,
        paymentStatus = PaymentStatus.EXPIRED,
        amountPaid = 0,
        remainingAmount = 320,
        source = AppointmentSource.PUBLIC_BOOKING,
        ghostFlag = false,
        client = AppointmentClient("client_007", "Jorge Castillo", "6147890123"),
        serviceSummary = listOf(
            AppointmentService("srv_007", "Afeitado", 60, 320)
        ),
        paymentUrl = "https://gala.test/pay/appt_007",
        notes = "No se presentó.",
        paymentSummary = AppointmentPaymentSummary(320, 0, 320, false)
    ),
    Appointment(
        id = "appt_008",
        scheduledStart = "2026-07-16 10:00",
        scheduledEnd = "2026-07-16 11:00",
        appointmentStatus = AppointmentStatus.CONFIRMED,
        paymentStatus = PaymentStatus.PAID,
        amountPaid = 280,
        remainingAmount = 0,
        source = AppointmentSource.MANUAL_OWNER,
        ghostFlag = false,
        client = AppointmentClient("client_008", "Sofia Herrera", "6148901234"),
        serviceSummary = listOf(
            AppointmentService("srv_008", "Peinado", 60, 280)
        ),
        paymentUrl = "",
        notes = "",
        paymentSummary = AppointmentPaymentSummary(280, 280, 0, true)
    ),
    Appointment(
        id = "appt_009",
        scheduledStart = "2026-07-16 13:00",
        scheduledEnd = "2026-07-16 14:30",
        appointmentStatus = AppointmentStatus.PENDING,
        paymentStatus = PaymentStatus.FAILED,
        amountPaid = 0,
        remainingAmount = 600,
        source = AppointmentSource.PUBLIC_BOOKING,
        ghostFlag = false,
        client = AppointmentClient("client_009", "Ricardo Nunez", "6149012345"),
        serviceSummary = listOf(
            AppointmentService("srv_009", "Color completo", 90, 600)
        ),
        paymentUrl = "https://gala.test/pay/appt_009",
        notes = "Intento de cobro fallido.",
        paymentSummary = AppointmentPaymentSummary(600, 0, 600, false)
    ),
    Appointment(
        id = "appt_010",
        scheduledStart = "2026-07-16 17:00",
        scheduledEnd = "2026-07-16 18:30",
        appointmentStatus = AppointmentStatus.CONFIRMED,
        paymentStatus = PaymentStatus.PAID,
        amountPaid = 700,
        remainingAmount = 0,
        source = AppointmentSource.MANUAL_OWNER,
        ghostFlag = false,
        client = AppointmentClient("client_010", "Valeria Mendez", "6140123456"),
        serviceSummary = listOf(
            AppointmentService("srv_010", "Tratamiento capilar", 90, 700)
        ),
        paymentUrl = "",
        notes = "Requiere seguimiento en 3 semanas.",
        paymentSummary = AppointmentPaymentSummary(700, 700, 0, true)
    ),
)
