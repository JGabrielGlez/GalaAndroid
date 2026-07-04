package com.drgabo.galaandroid.views.components

import androidx.compose.foundation.background
import  com.drgabo.galaandroid.views.icons.home
import  com.drgabo.galaandroid.views.icons.menu
import  com.drgabo.galaandroid.views.icons.account_circle
import  com.drgabo.galaandroid.views.icons.content_cut
import  com.drgabo.galaandroid.views.icons.view_agenda
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.navigation.AppDestinations
import com.drgabo.galaandroid.views.theme.AcentoPrincipal
import com.drgabo.galaandroid.views.theme.AcentoSuave
import com.drgabo.galaandroid.views.theme.GalaAndroidTheme
import com.drgabo.galaandroid.views.theme.NeutroBorde


enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME(AppDestinations.OWNER_DASHBOARD, "Inicio", home, "Inicio"),
    AGENDA(AppDestinations.OWNER_AGENDA, "Agenda", view_agenda, "Agenda"),

    SERVICES(AppDestinations.OWNER_SERVICES, "Servicios", content_cut, "Servicios"),
    CLIENTS(
        route = AppDestinations.OWNER_CLIENTS,
        label = "Clientes",
        icon = account_circle,
        contentDescription = "Clientes"
    ),
    MORE(route = AppDestinations.OWNER_MORE, label = "Más", icon = menu, contentDescription = "Menu")
}


@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    //se delega la navegación al padre, que en este caso es el scaffold
    currentRoute:String?,
    onNavigate:(String)-> Unit) {

    Box(modifier = modifier){

        NavigationBar(windowInsets = NavigationBarDefaults.windowInsets,
            containerColor = Color.White
        ) {
            Destination.entries.forEach { destination ->
                NavigationBarItem(
                    selected = currentRoute == destination.route,
                    onClick = {
                       onNavigate(destination.route)
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
                            if (currentRoute == destination.route) {
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
            thickness = 1.dp,
            color = NeutroBorde,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavBarThemePreview(){
    GalaAndroidTheme {
        NavBar(
            currentRoute = AppDestinations.OWNER_CLIENTS,
            onNavigate = {}
        )
    }
}

