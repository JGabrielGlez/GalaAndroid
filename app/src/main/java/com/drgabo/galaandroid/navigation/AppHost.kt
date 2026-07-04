package com.drgabo.galaandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.drgabo.galaandroid.views.components.GalaText
import com.drgabo.galaandroid.views.components.ScaffoldPrincipal
import com.drgabo.galaandroid.views.screens.*
//sirve para decidir qué pantalla mostrar, cuál es la pantalla inicial y qué rutas existen dentro de la app

//la navegación también forma parte del árbol de UI, por eso también entra dentro de Composable
@Composable
fun AppHost(){

//este es el objeto que controla la navegación: el dónde está, a dónde se puede ir, cómo volver y cómo cambiar de ruta
    val navController = rememberNavController()//es remember porque es necesario conservar el mismo controlador
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val onNavigate:(String)->Unit={route->
        if(route!=currentRoute){
            //Esta validación es para checar si se está dentro de lo que es la misma ruta
            //para evitar que se duplique la misma pantalla dos veces, evitando loops
            navController.navigate(route){
                popUpTo(navController.graph.startDestinationId){
                    saveState=true;
                }
                launchSingleTop=true;
                restoreState=true
            }
        }
    }

    //Contenedor que renderiza la pantalla actual según la ruta activa
    NavHost(
        navController=navController,
        startDestination = AppDestinations.OWNER_CLIENTS
    ) {
        //se debe declarar una entrada por ruta
        //Si la ruta actual es esta... Dibujas la pantalla del bloque
        //Clientes
        composable(route = AppDestinations.OWNER_CLIENTS){
            OwnerClients(
                //  OwnerClients necesita recibir esos datos para pasarlos a ScaffoldPrincipal, y
                //  luego ScaffoldPrincipal se los pasa a NavBar.

                currentRoute=currentRoute,
                onNavigate=onNavigate
            )
        }

        //Dashboard
        composable (route= AppDestinations.OWNER_DASHBOARD){
            OwnerDashboard(
                currentRoute = currentRoute,
                onNavigate = onNavigate
            )
        }


        //Agenda - Inicio
        composable (route= AppDestinations.OWNER_AGENDA){
            //OwnerAgenda(), ESTA AÚN NO ESTÁ
            OwnerAgenda(
                currentRoute=currentRoute,
                onNavigate = onNavigate
            )
        }

        composable(route = AppDestinations.OWNER_SERVICES) {
            PlaceholderMainScreen(
                title = "Servicios",
                currentRoute = currentRoute,
                onNavigate = onNavigate
            )
        }

        composable(route = AppDestinations.OWNER_MORE) {
            PlaceholderMainScreen(
                title = "Mas",
                currentRoute = currentRoute,
                onNavigate = onNavigate
            )
        }
    }
}

@Composable
private fun PlaceholderMainScreen(
    title: String,
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    ScaffoldPrincipal(
        nombrePantalla = title,
        showFab = false,
        currentRoute = currentRoute,
        onNavigate = onNavigate
    ) {
        item {
            GalaText(texto = "$title provisional")
        }
    }
}
