package com.drgabo.galaandroid.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.core.ui.theme.AcentoPrincipal
import com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.core.ui.theme.NeutroBlanco
import com.drgabo.galaandroid.core.ui.theme.TextoPrimario
import com.drgabo.galaandroid.core.ui.theme.NeutroBorde
@Composable
fun GalaButton(
    onClick:()->Unit,
    isPrimary:Boolean=true,
    text:String,
    modifier: Modifier= Modifier
){
    val colorTexto: Color
    val colorBg: Color
    val shape= RoundedCornerShape(16.dp)
    
    
    if(isPrimary){
        colorTexto=NeutroBlanco
        colorBg=AcentoPrincipal
    }else{
        colorTexto=TextoPrimario
        colorBg=NeutroBlanco
    }

    Button(
        onClick = onClick,
        shape=shape,
        border = if(isPrimary) null else{
            BorderStroke(width = 1.dp,
                color = NeutroBorde)
        },
        colors= ButtonDefaults.buttonColors(colorBg),
        modifier = modifier
    ) {
        GalaText(
            text,
            colorTexto = colorTexto.copy(alpha = .9f),
            peso= FontWeight.Bold
        )
    }
}


@Preview(showBackground = true, widthDp = 390)
@Composable
fun ShowButtonPrimary(){
    GalaAndroidTheme {
        GalaButton(
            onClick = {},
            text = "Entrar"
            )
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun ShowButtonSecondary(){
    GalaAndroidTheme {
        GalaButton(
            isPrimary = false,
            onClick = {},
            text = "Cerrar sesión"
        )
    }
}