package com.drgabo.galaandroid.feature.clients.domain.repositories

import com.drgabo.galaandroid.feature.clients.domain.models.OwnerClientListItem

interface OwnerClientsRepository {
    //Se usa result específicamente cuando sabemos que algo puede fallar, en ese caso como se conulta una api, se da por hecho que hay dos estados, success o failed. Si fueran datos locales podría retornar directamente el tipo del valor
    suspend fun getClients(): Result<List<OwnerClientListItem>>
    //se hace con posible nulo para que nulo signifique no encontrado, en lugar de lanzar una exception, estas se pueden reservar para errores reales de conexión o API
    //todo el cliente buscado será siempre sacado de la lista cacheada, por lo que nunca será nulo el valor retornado
    suspend fun getClientById(id:String): Result<OwnerClientListItem>
}