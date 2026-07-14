package com.drgabo.galaandroid.core

import com.drgabo.galaandroid.feature.auth.data.remote.dto.OwnerLoginResponseDto
import com.drgabo.galaandroid.feature.auth.domain.models.OwnerLoginResponse


//archivo temporal


//Guarda en memoria la sesion actual, si se cierra la app se pierde
object SessionManager {
    var currentSession: OwnerLoginResponse?=null
    val accessToken:String?
        get()= currentSession?.session?.accessToken
}