package com.drgabo.galaandroid.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.navigation.AppDestinations
import com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.core.ui.theme.TextoSecundario
import com.drgabo.galaandroid.core.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPrincipal(
    nombrePantalla: String,
    onFabClick: () -> Unit = {},
    showFab: Boolean,
    showSearchBar: Boolean = false,
    searchBarPlaceholder: String = "",
    searchBarQuery: String = "",
    onSearchBarOnQueryChange: (String) -> Unit = {},
    esPantallaClientes: Boolean = false,

    currentRoute: String?,
    onNavigate: (String)->Unit,
    content: LazyListScope.() -> Unit,

    ) {

    val spacing = if (esPantallaClientes) 0.dp else 16.dp
    //var presses by remember { mutableIntStateOf(0) }
    GalaAndroidTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.White,


            topBar = {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    DashboardHeader(userName = nombrePantalla)

                    if (showSearchBar) {
                        OutlinedTextField(
                            value = searchBarQuery,
                            onValueChange = onSearchBarOnQueryChange,
                            placeholder = {
                                GalaText(
                                    texto = searchBarPlaceholder,
                                    estilo = Typography.bodySmall,
                                    colorTexto = TextoSecundario,
                                    peso = FontWeight.Normal
                                )
                            },
                            shape = RoundedCornerShape(30),
                            modifier = Modifier
                                .fillMaxWidth(),
                            singleLine = true

                        )
                    }
                }
            },
            bottomBar = {
                NavBar(
                    currentRoute =currentRoute,
                    onNavigate = onNavigate
                )
            },
            floatingActionButton = {
                if (showFab)
                    FAB(onClick = onFabClick)
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(
                    space = spacing,
                ),
            ) { content()
            }
        }
    }
}

@Preview
@Composable
fun MostrarEsqueleto() {
    ScaffoldPrincipal(
        nombrePantalla = "Prueba,",
        showFab = true,
        showSearchBar = true,
        searchBarPlaceholder = "hola",
        currentRoute = AppDestinations.OWNER_CLIENTS,
        onNavigate = {},
    ) {


    }
}
