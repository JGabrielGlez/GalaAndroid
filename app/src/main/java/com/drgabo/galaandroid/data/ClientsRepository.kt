package com.drgabo.galaandroid.data

interface ClientsRepository{
    fun getClients():List<Client>
    fun getClientById(id: String): Client

}