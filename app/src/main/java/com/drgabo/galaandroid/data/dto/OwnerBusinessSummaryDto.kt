package com.drgabo.galaandroid.data.dto

import com.drgabo.galaandroid.data.enums.CommercialStatusDto
import com.drgabo.galaandroid.feature.appointments.data.remote.dto.ThemeId
import kotlinx.serialization.Serializable

@Serializable
data class OwnerBusinessSummaryDto(
    val negocioId: String,
    val slug: String,
    val nombre: String,
    val ownerName: String,
    val ownerEmail: String,
    val timezone: String,
    val commercialStatus: CommercialStatusDto,
    val themeId: ThemeId,
)