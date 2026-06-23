package com.drgabo.galaandroid.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.drgabo.galaandroid.ui.theme.MonstserratFamily


@Composable
fun GalaText(texto:String, modifier : Modifier= Modifier){
  Text(
    modifier=modifier,
    fontFamily = MonstserratFamily,
    text = texto
  )
}