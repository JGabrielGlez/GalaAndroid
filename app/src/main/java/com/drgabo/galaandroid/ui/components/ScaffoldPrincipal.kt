package com.drgabo.galaandroid.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.ui.components.*
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPrincipal(
                      nombrePantalla:String,
                      onFabClick:()->Unit={},
                      showFab:Boolean,
                      content:@Composable ()->Unit)
                       {
  //var presses by remember { mutableIntStateOf(0) }
GalaAndroidTheme {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    containerColor = Color.White,
    topBar = {
      Column(
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {
          DashboardHeader(userName =nombrePantalla )
      }
    },
    bottomBar = {
      NavBar()
    },
    floatingActionButton = {
      if(showFab)
        FAB(onClick = onFabClick)
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .padding(horizontal = 12.dp),

      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      content()
    }
  }}
}

