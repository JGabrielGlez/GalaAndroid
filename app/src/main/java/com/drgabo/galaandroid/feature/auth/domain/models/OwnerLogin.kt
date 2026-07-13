package com.drgabo.galaandroid.feature.auth.domain.models

data class OwnerSession(
    val ownerId: String,
    val ownerName: String,
    val ownerEmail: String,
    val businessId: String,
    val businessSlug: String,
)

data class OwnerLoginRequest(
    val email: String,
    val password: String,
    val redirectTo: String? = null,
)

data class OwnerLoginResponse(
    val owner: OwnerLoginOwner,
    val session: OwnerLoginSession,
    val businessContext: OwnerLoginBusinessContext,
    val nextAction: OwnerLoginNextAction,
)

data class OwnerLoginOwner(
    val id: String,
    val email: String,
    val name: String,
)

data class OwnerLoginSession(
    val accessToken: String,
    val expiresAt: String,
)

data class OwnerLoginBusinessContext(
    val negocioId: String,
    val slug: String,
    val commercialStatus: CommercialStatus,
    val bookingEnabled: Boolean,
    val profileComplete: Boolean,
)

enum class OwnerLoginNextAction {
    OPEN_DASHBOARD,
    COMPLETE_SETUP,
    RESOLVE_COMMERCIAL_BLOCK,
}
