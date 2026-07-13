package com.drgabo.galaandroid.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.core.ui.theme.AcentoPrincipal
import com.drgabo.galaandroid.core.ui.theme.AcentoSuave
import com.drgabo.galaandroid.core.ui.theme.AcentoFondo
import com.drgabo.galaandroid.core.ui.theme.Typography


//El modal debe recibir un mensaje y nada más

@Composable
fun FullScreenModal(
    message: String,
    modifier:Modifier= Modifier
){
    Column (
        modifier = modifier.background(AcentoFondo),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = modifier.width(64.dp),
            color = AcentoPrincipal,
            trackColor = AcentoSuave
        )
        HorizontalDivider(
            thickness = 40.dp,
            color = Color.Transparent)

        GalaText(
            textoCentrado = true,
            texto = message,
            estilo = Typography.titleMedium,
            peso= FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(.7f)
        )
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 1080)
@Composable
fun MostrarProgreso(){
    FullScreenModal(
        message = "Mostrando progreso"
    )
}