package com.drgabo.galaandroid.feature.clients.data.remote.mappers

import com.drgabo.galaandroid.feature.clients.data.remote.dto.ClientDto
import com.drgabo.galaandroid.feature.clients.domain.models.Client

fun ClientDto.toDomain(): Client {
    return Client(
        id = this.id,
        nombre = this.nombre,
        telefono = this.telefono,
        email = this.email,
        cancelaciones = this.cancelaciones,
        noShow = this.noShow,
        primeraVisitaAt = this.primeraVisitaAt,
        ultimaVisitaAt = this.ultimaVisitaAt,
        appointmentCount = this.appointmentCount,
        proximaCitaId = this.proximaCitaId,
        proximaCitaAt = this.proximaCitaAt,
        historialReciente = this.historialReciente?.map { appointment ->
            appointment.toDomain()
        },
        ultimaCitaStatus = this.ultimaCitaStatus,
    )
}
