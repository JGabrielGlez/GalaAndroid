package com.drgabo.galaandroid.feature.clients.domain.usecases

import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem
import com.drgabo.galaandroid.feature.clients.domain.repositories.OwnerClientsRepository

class GetOwnerClientsUseCase(
    //recibe el repository para que sea agnóstico de la fuente de datos, así yo le puedo mandar ya sea una fuente de datos fake o una de api
    //el repo es el que conoce
    private val repository: OwnerClientsRepository
){
    suspend operator fun invoke(): Result<List<OwnerClientListItem>>{
        return repository.getClients()
    }
}