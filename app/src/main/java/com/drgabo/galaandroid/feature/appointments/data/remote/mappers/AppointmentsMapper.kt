package com.drgabo.galaandroid.feature.appointments.data.remote.mappers


import com.drgabo.galaandroid.feature.appointments.data.remote.dto.OwnerAppointmentListItemDto
import com.drgabo.galaandroid.feature.appointments.domain.models.Appointment

fun OwnerAppointmentListItemDto.toDomain(): Appointment {
    return Appointment(
        id = this.id,
        scheduledStart = this.scheduledStart,
        scheduledEnd = this.scheduledEnd,
        appointmentStatus = this.appointmentStatus.toDomain(),
        paymentStatus = this.paymentStatus.toDomain(),
        amountPaid = this.amountPaid,
        remainingAmount = this.remainingAmount,
        source = this.source.toDomain(),
        ghostFlag = this.ghostFlag,
        client = requireNotNull(this.client){
            "El cliente llegó vacío"
        }.toDomain(),
        serviceSummary = requireNotNull(this.serviceSummary){
            "El servicio solicitado no se envió"
        }.also {
            //el also es para validar que el contenido de la lista no sea vacío
            //es decir, no entregar tal cual "[]", sino validar completamente el objeto esperado
            services->
            require(services.isNotEmpty()){
                "Service Summary no debe venir como lista vacía"
            }
        }.
        map { service->
            service.toDomain()
        },
        //manejaré que tanto payments como notes estén en cadena vacía.
        paymentUrl = this.paymentUrl?:"",
        notes = this.notes?:"",
        paymentSummary=requireNotNull(this.paymentSummary){
            "No se registró correctamente los datos del pago"
        }.toDomain(),
    )
}