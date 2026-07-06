package com.drgabo.galaandroid.feature.clients.domain.repositories

import com.drgabo.galaandroid.feature.clients.domain.models.Client

interface ClientsRepository{
    fun getClients():List<Client>
    fun getClientById(id: String): Client

}