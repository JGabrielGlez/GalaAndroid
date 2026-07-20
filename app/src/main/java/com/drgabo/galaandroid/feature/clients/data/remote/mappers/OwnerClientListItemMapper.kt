package com.drgabo.galaandroid.feature.clients.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.mappers.toDomain
import com.drgabo.galaandroid.feature.clients.data.remote.dto.OwnerClientListItemDto
import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem


fun OwnerClientListItemDto.toDomain(): OwnerClientListItem{
    return OwnerClientListItem(
        id = this.id,
        nombre = this.nombre,
        telefono = this.telefono,
        email = this.email,
        cancelaciones = this.cancelaciones,
        primeraVisitaAt = this.primeraVisitaAt,
        ultimaVisitaAt = this.ultimaVisitaAt,
        appointmentsCount = this.appointmentsCount?:0,
        proximaCitaId = this.proximaCitaId,
        proximaCitaAt = this.proximaCitaAt,
        historialReciente = this.historialReciente?.toDomain(),
        ultimaCitaStatus = this.ultimaCitaStatus?.toDomain()
    )
}