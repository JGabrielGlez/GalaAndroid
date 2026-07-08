package com.drgabo.galaandroid.feature.appointments.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ServiceDto(
    val serviceId: String? = null,
    val nombre: String,
    val duracionMin: Int,
    val precio: Int,
)