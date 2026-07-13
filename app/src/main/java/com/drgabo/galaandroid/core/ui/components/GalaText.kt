package com.drgabo.galaandroid.core.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.drgabo.galaandroid.core.ui.theme.Typography
import com.drgabo.galaandroid.core.ui.theme.MonstserratFamily


@Composable
fun GalaText(texto:String,
             colorTexto:Color=Color.Black,
             modifier : Modifier= Modifier,
             estilo: TextStyle= Typography.bodyMedium,
             peso: FontWeight= FontWeight.Normal,
             textoCentrado: Boolean=false
){
  Text(

    modifier=modifier,
    fontFamily = MonstserratFamily,
    text = texto,
    color = colorTexto,
    style = estilo,
      fontWeight = peso,
    textAlign = if(textoCentrado) TextAlign.Center else TextAlign.Start
  )
}
