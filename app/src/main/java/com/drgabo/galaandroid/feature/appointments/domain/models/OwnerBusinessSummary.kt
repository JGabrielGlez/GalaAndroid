package com.drgabo.galaandroid.feature.appointments.domain.models

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
