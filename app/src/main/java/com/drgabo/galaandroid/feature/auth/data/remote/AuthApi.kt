package com.drgabo.galaandroid.feature.auth.data.remote

import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginRequestDto
import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginResponseDto
import okhttp3.Request
import retrofit2.http.Body
import retrofit2.http.POST

//Son directas a lo que son los DTOs porque es tal cual donde se debe de almacenar la información, describe todo lo necesario para que la api funcione correctamente
interface AuthApi {
    @POST("api/auth/login")
    suspend fun login(
        @Body request: OwnerLoginRequestDto
    ): OwnerLoginResponseDto
}