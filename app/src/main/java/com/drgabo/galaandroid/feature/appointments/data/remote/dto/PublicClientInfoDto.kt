package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PublicClientInfoDto(
    val id: String,
    val nombre: String,
    val telefono: String,
)