package com.drgabo.galaandroid.ui.components

import android.graphics.drawable.Icon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.R
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme


@Composable
fun IconButton(onClick:()->Unit, icon: Int){
    IconButton(
        onClick = onClick

    ) {
        Icon(
            tint = Color.Unspecified,
            painter = painterResource(id=icon),
            contentDescription = "WhatsApp"
        )

    }
}


@Preview(showBackground = true, widthDp = 390)
@Composable
fun MostrarIconButton(){
    GalaAndroidTheme {
        IconButton(onClick = {}, icon = R.drawable.whatsapp_icon)
    }
}