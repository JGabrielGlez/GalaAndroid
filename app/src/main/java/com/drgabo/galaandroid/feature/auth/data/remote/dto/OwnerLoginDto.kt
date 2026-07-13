package com.drgabo.galaandroid.feature.auth.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerSessionDto(
    val ownerId: String,
    val ownerName: String,
    val ownerEmail: String,
    val businessId: String,
    val businessSlug: String,
)

@Serializable
data class OwnerLoginRequestDto(
    val email: String,
    val password: String,
    val redirectTo: String? = null,
)

@Serializable
data class OwnerLoginResponseDto(
    val owner: OwnerLoginOwnerDto,
    val session: OwnerLoginSessionDto,
    val businessContext: OwnerLoginBusinessContextDto,
    val nextAction: OwnerLoginNextActionDto,
)

@Serializable
data class OwnerLoginOwnerDto(
    val id: String,
    val email: String,
    val name: String,
)

@Serializable
data class OwnerLoginSessionDto(
    val accessToken: String,
    val expiresAt: String,
)

@Serializable
data class OwnerLoginBusinessContextDto(
    val negocioId: String,
    val slug: String,
    val commercialStatus: CommercialStatusDto,
    val bookingEnabled: Boolean,
    val profileComplete: Boolean,
)

@Serializable
enum class OwnerLoginNextActionDto {
    @SerialName("open_dashboard")
    OPEN_DASHBOARD,

    @SerialName("complete_setup")
    COMPLETE_SETUP,

    @SerialName("resolve_commercial_block")
    RESOLVE_COMMERCIAL_BLOCK,
}
