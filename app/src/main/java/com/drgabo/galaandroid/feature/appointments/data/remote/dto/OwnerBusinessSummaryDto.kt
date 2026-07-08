package com.drgabo.galaandroid.feature.appointments.data.remote.dto

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
