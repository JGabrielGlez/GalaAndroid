package com.drgabo.galaandroid.feature.auth.domain.repositories

import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginRequest
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginResponse

interface AuthRepository {
    suspend fun login(request: OwnerLoginRequest): OwnerLoginResponse
}
