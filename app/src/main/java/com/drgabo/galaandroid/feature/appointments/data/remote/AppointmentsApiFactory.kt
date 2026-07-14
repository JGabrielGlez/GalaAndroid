package com.drgabo.galaandroid.feature.appointments.data.remote

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

//construye el objeto de retrofit, se crea la maquina que sabe la url base, como hacer los requiest, como convertir json a DTOs y como mostrar los logs en desarrollo
object AppointmentsApiFactory{
    fun create(): AppointmentsApi {
        //ver en logcate url, req, res, body
        val loggingInterceptor= HttpLoggingInterceptor().apply{
            level= HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        val json=Json{
            ignoreUnknownKeys=true
        }
    //todo: cambiar la base url por la de deploy
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.110:3000/")
            .client(client)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(AppointmentsApi::class.java)
    }
}