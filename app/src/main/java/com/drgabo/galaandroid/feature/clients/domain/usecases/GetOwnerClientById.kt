package com.drgabo.galaandroid.feature.clients.domain.usecases

import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem
import com.drgabo.galaandroid.feature.clients.domain.repositories.OwnerClientsRepository

class GetOwnerClientById (
    private val repository: OwnerClientsRepository
){
    suspend fun invoke(id:String): Result<OwnerClientListItem>{
        return  repository.getClientById(id)
    }
}