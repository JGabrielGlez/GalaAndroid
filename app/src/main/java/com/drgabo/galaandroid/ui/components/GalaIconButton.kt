package com.drgabo.galaandroid.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.R
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme

sealed class GalaIcon {
    data class DrawableIcon(val resId: Int, val contentDes: String) : GalaIcon()
    data class VectorIcon(val imgVector: ImageVector, val contentDes: String) : GalaIcon()
}

@Composable
fun GalaIconButton(
    onClick: () -> Unit,
    icon: GalaIcon,
    modifier: Modifier = Modifier,
    modifiersIcon: Modifier = Modifier.size(20.dp)
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .clickable(enabled = true, onClick = onClick)
            .clip(shape = CircleShape)
            .background(color = Color.Transparent),
        contentAlignment = Alignment.Center,


        ) {
        when (icon) {
            is GalaIcon.DrawableIcon -> {

                Icon(
                    tint = Color.Unspecified,
                    painter = painterResource(id = icon.resId),
                    modifier = modifiersIcon,
                    contentDescription = icon.contentDes

                )
            }

            is GalaIcon.VectorIcon -> {

                Icon(
                    imageVector = icon.imgVector, // aquí usarías tu ícono descargado
                    tint = MaterialTheme.colorScheme.onSurface,
                    contentDescription = icon.contentDes,
                    modifier = modifiersIcon
                )

            }
        }

    }
}


@Preview(showBackground = true, widthDp = 390, backgroundColor = 0xFFFFFFFF)
@Composable
fun MostrarIconButton() {
    GalaAndroidTheme {
        GalaIconButton(
            onClick = {},
            icon = GalaIcon.DrawableIcon(
                R.drawable.whatsapp_icon,
                contentDes = "Whatsapp"
            )
        )
    }
}