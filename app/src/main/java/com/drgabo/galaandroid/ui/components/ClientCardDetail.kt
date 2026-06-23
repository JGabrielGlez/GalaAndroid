package com.drgabo.galaandroid.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.ui.theme.AcentoSuave
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.ui.theme.MonstserratFamily



@Composable
fun ClientCardDetail(nombre: String, ultimaVisita: String, noCitas: Int, modifier: Modifier=Modifier) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(64.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .clickable(
          enabled = true,
          onClick = {println(message = "Cliente presionado")}
        )
        .padding(12.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      //Círculo con la inicial
      Box(
        modifier = Modifier
          .size(32.dp)
        .clip(shape = CircleShape)
          .background(color= AcentoSuave.copy(alpha=.7f))
          .padding(4.dp),
        contentAlignment = Alignment.Center
      ){
        GalaText(nombre.first().toString().uppercase())
      }
      //columna con los datos

      //icon
    }

  }
}

@Preview
@Composable
fun MostrarCard(){
  GalaAndroidTheme {
    ClientCardDetail(nombre = "gabriel", ultimaVisita = "12 de junio", noCitas = 2)
  }
}