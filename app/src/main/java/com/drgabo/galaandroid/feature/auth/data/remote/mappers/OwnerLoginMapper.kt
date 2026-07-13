package com.drgabo.galaandroid.feature.auth.data.remote.mappers

import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginBusinessContextDto
import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginNextActionDto
import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginOwnerDto
import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginRequestDto
import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginResponseDto
import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginSessionDto
import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerSessionDto
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginBusinessContext
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginNextAction
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginOwner
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginRequest
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginResponse
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginSession
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerSession

fun OwnerLoginRequest.toDto(): OwnerLoginRequestDto {
    return OwnerLoginRequestDto(
        email = this.email,
        password = this.password,
        redirectTo = this.redirectTo,
    )
}

fun OwnerLoginResponseDto.toDomain(): OwnerLoginResponse {
    return OwnerLoginResponse(
        owner = this.owner.toDomain(),
        session = this.session.toDomain(),
        businessContext = this.businessContext.toDomain(),
        nextAction = this.nextAction.toDomain(),
    )
}

fun OwnerLoginOwnerDto.toDomain(): OwnerLoginOwner {
    return OwnerLoginOwner(
        id = this.id,
        email = this.email,
        name = this.name,
    )
}

fun OwnerLoginSessionDto.toDomain(): OwnerLoginSession {
    return OwnerLoginSession(
        accessToken = this.accessToken,
        expiresAt = this.expiresAt,
    )
}

fun OwnerLoginBusinessContextDto.toDomain(): OwnerLoginBusinessContext {
    return OwnerLoginBusinessContext(
        negocioId = this.negocioId,
        slug = this.slug,
        commercialStatus = this.commercialStatus.toDomain(),
        bookingEnabled = this.bookingEnabled,
        profileComplete = this.profileComplete,
    )
}

fun OwnerLoginNextActionDto.toDomain(): OwnerLoginNextAction {
    return when (this) {
        OwnerLoginNextActionDto.OPEN_DASHBOARD -> OwnerLoginNextAction.OPEN_DASHBOARD
        OwnerLoginNextActionDto.COMPLETE_SETUP -> OwnerLoginNextAction.COMPLETE_SETUP
        OwnerLoginNextActionDto.RESOLVE_COMMERCIAL_BLOCK -> OwnerLoginNextAction.RESOLVE_COMMERCIAL_BLOCK
    }
}

fun OwnerSessionDto.toDomain(): OwnerSession {
    return OwnerSession(
        ownerId = this.ownerId,
        ownerName = this.ownerName,
        ownerEmail = this.ownerEmail,
        businessId = this.businessId,
        businessSlug = this.businessSlug,
    )
}
