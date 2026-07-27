package com.drgabo.galaandroid.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import  com.drgabo.galaandroid.core.ui.theme.*

@Composable
fun ClientBanner(
    backgrounColor: Color = AcentoSuave,
    nombre: String,
    telefono : String,
){
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Círculo con la inicial
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(shape = CircleShape)
                .background(color = AcentoSuave.copy(alpha = .7f))
                .padding(4.dp),

            contentAlignment = Alignment.Center
        ) {
            GalaText(
                nombre.first().toString().uppercase(),
                peso = FontWeight.SemiBold,
                estilo = Typography.bodyLarge
            )
        }

        GalaText(texto = nombre)
        GalaText(texto = telefono)
    }
}

@Preview
@Composable
fun ShowClientBanner(){
    GalaAndroidTheme {
        ClientBanner(

            nombre = "Gabrielon",
            telefono = "3111228805"
        )
    }
}