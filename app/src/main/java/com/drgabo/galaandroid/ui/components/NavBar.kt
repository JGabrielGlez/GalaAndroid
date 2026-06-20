package com.drgabo.galaandroid.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import  com.drgabo.galaandroid.ui.icons.home
import  com.drgabo.galaandroid.ui.icons.menu
import  com.drgabo.galaandroid.ui.icons.account_circle
import  com.drgabo.galaandroid.ui.icons.content_cut
import  com.drgabo.galaandroid.ui.icons.view_agenda
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drgabo.galaandroid.ui.theme.AcentoPrincipal
import com.drgabo.galaandroid.ui.theme.AcentoSuave
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.ui.theme.TextoSecundario

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Home Screen")
    }
}


@Composable
fun AgendaScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Agenda Screen")
    }
}


@Composable
fun ServiceScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Service Screen")
    }
}


@Composable
fun ClientScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Client Screen")
    }
}


@Composable
fun MoreScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("More Screen")
    }
}

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME("home", "Inicio", home, "Inicio"),
    AGENDA("agenda", "Agenda", view_agenda, "Agenda"),

    SERVICES("services", "Servicios", content_cut, "Servicios"),
    CLIENTS(
        route = "clients",
        label = "Clientes",
        icon = account_circle,
        contentDescription = "Clientes"
    ),
    MORE(route = "more", label = "Más", icon = menu, contentDescription = "Menú")
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController,
        startDestination = startDestination.route,

        ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.SERVICES -> ServiceScreen()
                    Destination.AGENDA -> AgendaScreen()
                    Destination.HOME -> HomeScreen()
                    Destination.CLIENTS -> ClientScreen()
                    Destination.MORE -> MoreScreen()
                }
            }
        }
    }
}

@Preview()
@Composable
fun NavBar(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = Destination.HOME
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Box(modifier = Modifier){

        NavigationBar(windowInsets = NavigationBarDefaults.windowInsets,
            containerColor = Color.White
        ) {
            Destination.entries.forEachIndexed { index, destination ->
                NavigationBarItem(
                    selected = selectedDestination == index,
                    onClick = {
                        navController.navigate(route = destination.route)
                        selectedDestination = index
                    },
                    icon = {
                        Icon(

                            destination.icon,
                            contentDescription = destination.contentDescription
                        )
                    },
                    label = { Text(destination.label) },
                    colors =
                        NavigationBarItemDefaults.colors(
                            selectedIconColor = AcentoPrincipal,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = AcentoPrincipal,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Transparent
                        ),
                    modifier = Modifier

                        .then(
                            if (selectedDestination == index) {
                                Modifier
                                    .size(64.dp)
                                    .padding(4.dp)
                                    .background(
                                        color = AcentoSuave.copy(alpha = .45f),
                                        shape = CircleShape,
                                    )
                            } else {
                                Modifier
                            }
                        )


                )
            }
        }
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavBarThemePreview(){
    GalaAndroidTheme {
        NavBar()
    }
}

