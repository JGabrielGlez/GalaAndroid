package com.drgabo.galaandroid.ui.components

import com.drgabo.galaandroid.ui.theme.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme

@Composable
fun BadgeEstado(
    surfaceModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,

    mensaje: String,
    colorFondo: Color = Color.Green.copy(alpha = .5f),
    colorTexto: Color = Color.Green,

    ) {
    Surface(
        modifier = surfaceModifier,
        color = colorFondo,
        contentColor = colorTexto,
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = mensaje,
            fontFamily = MonstserratFamily,
            modifier = textModifier
                .padding(horizontal = 8.dp, vertical = 2.dp),
            textAlign = TextAlign.Center,
            color = colorTexto,
        )
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun ShowBadgeEstado() {
    GalaAndroidTheme {
        BadgeEstado(
            mensaje = "Confirmada",
            colorFondo = EstadoConfirmadaFondo,
            colorTexto = EstadoConfirmada
        )

    }
}
