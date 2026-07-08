package com.drgabo.galaandroid.feature.appointments.data.remote.mappers

import com.drgabo.galaandroid.feature.appointments.data.remote.dto.PaymentStatusDto
import com.drgabo.galaandroid.feature.appointments.domain.models.PaymentStatus

fun PaymentStatusDto.toDomain(): PaymentStatus{
    //el this en este caso hace referencia al objeto que lo mandó a llamar
    //Cuando this sea igual a Partially_pay, harás-> esto
    //al haer una función extensión, lo que hace es "Meter" dentro de los parámetros al objeto que lo mandó
    //a llamar, y ese objeto puede tener cualquier de los valores que están a al izquierda de los operandos
    return when (this){
        PaymentStatusDto.PARTIALLY_PAID-> PaymentStatus.PARTIALLY_PAID
        PaymentStatusDto.REFUNDED-> PaymentStatus.REFUNDED
        PaymentStatusDto.EXPIRED-> PaymentStatus.EXPIRED
        PaymentStatusDto.UNPAID-> PaymentStatus.UNPAID
        PaymentStatusDto.FAILED-> PaymentStatus.FAILED
        PaymentStatusDto.PAID -> PaymentStatus.PAID
    }
}