package com.drgabo.galaandroid.navigation

//la navegación se encarga de definir rutas, centralizar nombres de pantallas
//evitar strings repetidos en todo el proyecto


//En este objeto se definen las rutas a usar, aquí se declararán las que estarán disponibles
object AppDestinations{
    const val OWNER_CLIENTS="owner_clients"
    const val OWNER_SUMMARY="owner_summary"
    const val OWNER_AGENDA="owner_agenda"
    const val OWNER_SERVICES="owner_services"
    const val OWNER_MORE="owner_more"
    const val OWNER_CLIENT_DETAILS="owner_client_detail/{clientId}"

    //Calcular la ruta según los datos a usar de lo que es el cliente
    fun clientDetail (clientId:String):String{
        return "owner_client_detail/$clientId"
    }

    fun selectedTabRoute(route:String?):String?{
        return when (route){
            //Lo que hace es "Decir que x pertece a Y" de esta manera queda seleccionada la ruta de OwnerClients cuando se está en el detalla
            OWNER_CLIENT_DETAILS->OWNER_CLIENTS
            else -> route
        }
    }
}
