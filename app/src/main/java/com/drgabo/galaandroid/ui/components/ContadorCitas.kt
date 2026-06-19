package com.drgabo.galaandroid.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContadorCitas(cantidad:Int, texto: String, modifier: Modifier= Modifier){
    Column(

        Modifier.height(64.dp),
        //ya tengo que abarque todo a los lados, centrado, me falta si acaso cierto gap
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(cantidad.toString())
        Text(text = texto,
            style = MaterialTheme.typography.,
            )

    }
}

@Preview(showBackground = true)
@Composable
fun mostrarContadorSolo(){
    ContadorCitas(cantidad = 12, texto = "Citas pendientes")
}


@Preview(showBackground = true)
@Composable
fun mostrarContadorCol(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,

        verticalAlignment = Alignment.CenterVertically,

    ) {
        ContadorCitas(cantidad = 12, texto = "Citas pendientes", modifier =Modifier.weight(1f))

        ContadorCitas(cantidad = 12, texto = "Citas pendientes", modifier =Modifier.weight(1f))
        ContadorCitas(cantidad = 12, texto = "Citas pendientes", modifier =Modifier.weight(1f))
    }
}