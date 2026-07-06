package com.drgabo.galaandroid.core.ui.theme
//Nota: si hay variables o tokens en este caso dentro del mismo paquete, no es necesario importarlos porque están en la misma ubicación, por lo que los lee perfectamente
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



//Estoy creando un tema de colores normal, en base a lo que es el diseño del figma.
private val NormalColorScheme = lightColorScheme(
    primary = AcentoPrincipal,
    onPrimary = Color.White,

    primaryContainer = AcentoFondo,
    onPrimaryContainer = AcentoPrincipal,

    secondary = AcentoSuave,
    onSecondary = TextoPrimario,

    secondaryContainer = AcentoFondo,
    onSecondaryContainer = TextoPrimario,


    background = NeutroFondoPrincipal,
    onBackground = TextoPrimario,

    surface=NeutroBlanco,
    onSurface = TextoPrimario,

    outline = NeutroBorde,
    error=EstadoCancelada,
    onError = Color.White,

    errorContainer = EstadoCanceladaFondo,
    onErrorContainer = EstadoCancelada,

    surfaceVariant = AcentoFondo,
    onSurfaceVariant = TextoSecundario,

)

@Composable
fun GalaAndroidTheme(
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = NormalColorScheme,
        typography = Typography,
        content = content
    )
}
