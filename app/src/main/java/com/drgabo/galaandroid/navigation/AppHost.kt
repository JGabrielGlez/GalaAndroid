package com.drgabo.galaandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
            OwnerClients()
        }

        //Dashboard
        composable (route= AppDestinations.OWNER_DASHBOARD){
            OwnerDashboard()
        }


        //Agenda - Inicio
        composable (route= AppDestinations.OWNER_AGENDA){
            //OwnerAgenda(), ESTA AÚN NO ESTÁ
        }
    }
}
