package com.drgabo.galaandroid.feature.auth.data.remote

import com.drgabo.galaandroid.core.SessionManager
import com.drgabo.galaandroid.feature.auth.data.remote.mappers.toDomain
import com.drgabo.galaandroid.feature.auth.data.remote.mappers.toDto
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginRequest
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginResponse
import com.drgabo.galaandroid.feature.auth.domain.repositories.AuthRepository

//conecta contrato de dominio con retrofil
class RemoteAuthRepository (
    private val authApi: AuthApi

): AuthRepository{
    override suspend fun login(request: OwnerLoginRequest): OwnerLoginResponse {
       val responseDto = authApi.login(request.toDto())
        return responseDto.toDomain()
    }


    //Temporal ya que no tengo pantalla de login para iniciar sesión
    suspend fun loginHardcodedIfNeeded() {
        if (SessionManager.currentSession != null) return

        val response = login(
            OwnerLoginRequest(
                email = "jesusgabrielgonzaleses2@gmail.com",
                password = "11111111"
            )
        )

        SessionManager.currentSession = response
    }

}