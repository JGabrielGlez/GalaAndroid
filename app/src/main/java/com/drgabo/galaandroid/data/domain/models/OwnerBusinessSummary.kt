package com.drgabo.galaandroid.data.domain.models

import com.drgabo.galaandroid.feature.appointments.domain.models.CommercialStatus
import com.drgabo.galaandroid.feature.appointments.domain.models.ThemeId

data class OwnerBusinessSummary(
    val negocioId: String,
    val slug: String,
    val nombre: String,
    val ownerName: String,
    val ownerEmail: String,
    val timezone: String,
    val commercialStatus: CommercialStatus,
    val themeId: ThemeId,
)
