package com.drgabo.galaandroid.feature.appointments.data.remote

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.OwnerAgendaDayDto
import retrofit2.http.GET
import retrofit2.http.Header

interface AppointmentsApi {
     @GET("api/app/appointments/history")
     suspend fun getAgendaDays(
         //esto permite al repo pasar el token en cada req
         @Header("Authorization") authorization:String
     ): List<OwnerAgendaDayDto>
 }