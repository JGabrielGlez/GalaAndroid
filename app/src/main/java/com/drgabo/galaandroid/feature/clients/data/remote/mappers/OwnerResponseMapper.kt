package com.drgabo.galaandroid.feature.clients.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.mappers.toDomain
import com.drgabo.galaandroid.feature.clients.data.remote.dto.OwnerResponseDto
import com.drgabo.galaandroid.feature.clients.domain.models.OwnerResponse


fun OwnerResponseDto.toDomain(): OwnerResponse{
    return OwnerResponse(
        businessSummary = this.businessSummaryDto.toDomain(),
        segment = this.segment.toDomain(),
        query = this.query,
        clients = this.clients.map {
            clientListItemDto ->
            clientListItemDto.toDomain()
        },
        selectedClient = this.selectedClient?.toDomain(),
        realtime = this.realtime.toDomain()
    )
}