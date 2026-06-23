package com.drgabo.galaandroid.ui.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.ui.components.*
import com.drgabo.galaandroid.ui.theme.EstadoConfirmada
import com.drgabo.galaandroid.ui.theme.EstadoConfirmadaFondo
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.ui.theme.MonstserratFamily
import com.drgabo.galaandroid.ui.theme.NeutroBorde
import com.drgabo.galaandroid.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPrincipal(nombrePantalla: String = "Hola, María",
                      onFabClick:()->Unit={},
                      showFab:Boolean,
                      content:@Composable ()->Unit)
                       {
  //var presses by remember { mutableIntStateOf(0) }

  Scaffold(
    modifier = Modifier.fillMaxSize(),
    containerColor = Color.White,
    topBar = {
      Column(
        modifier = Modifier.padding(horizontal = 12.dp)
      ) {

        DashboardHeader(userName = nombrePantalla)
        HorizontalDivider(
          thickness = 1.dp, color = NeutroBorde
        )
        HorizontalDivider(
          color = Color.Transparent,
          thickness = 12.dp
        )
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
  }
}
