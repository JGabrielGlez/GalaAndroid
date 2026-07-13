package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.OwnerBusinessSummaryDto
import com.drgabo.galaandroid.feature.appointments.domain.models.OwnerBusinessSummary

fun OwnerBusinessSummaryDto.toDomain(): OwnerBusinessSummary {
    return OwnerBusinessSummary(
        negocioId = this.negocioId,
        slug = this.slug,
        nombre = this.nombre,
        ownerName = this.ownerName,
        ownerEmail = this.ownerEmail,
        timezone = this.timezone,
        commercialStatus = this.commercialStatus.toDomain(),
        themeId = this.themeId.toDomain(),
    )
}
