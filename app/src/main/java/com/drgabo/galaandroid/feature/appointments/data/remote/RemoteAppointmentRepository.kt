package com.drgabo.galaandroid.feature.appointments.data.remote

import com.drgabo.galaandroid.core.SessionManager
import com.drgabo.galaandroid.feature.appointments.data.remote.mappers.toDomain
import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerAgendaDay
import com.drgabo.galaandroid.feature.appointments.domain.repositories.AppointmentRepository
import com.drgabo.galaandroid.feature.auth.data.remote.RemoteAuthRepository


class RemoteAppointmentRepository(
    private val api: AppointmentsApi,
    private val authRepository: RemoteAuthRepository
): AppointmentRepository{
    override suspend fun getAgendaDays(): List<OwnerAgendaDay> {
        authRepository.loginHardcodedIfNeeded()

        val token = requireNotNull(SessionManager.accessToken){
            "No hay token disponible"
        }
        val agendaDays=api.getAgendaDays(
            authorization = "Bearer $token"
        ).map { dto->
            dto.toDomain()
        }


//        cachedAppointments=agendaDays.flatMap {
//            day->
//            day.appointments
//        }

        return agendaDays

    }

    override suspend fun getAppointments(): List<Appointment> {
        TODO("Not yet implemented")
    }

    override fun getAppointmentById(id: String): Appointment {
        TODO("Not yet implemented")
    }
}