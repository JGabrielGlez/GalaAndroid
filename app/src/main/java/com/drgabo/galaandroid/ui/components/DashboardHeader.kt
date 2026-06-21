package com.drgabo.galaandroid.ui.components


import com.drgabo.galaandroid.ui.icons.notifications
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drgabo.galaandroid.ui.theme.GalaAndroidTheme
import com.drgabo.galaandroid.ui.theme.NeutroBorde

@Composable
fun DashboardHeader(
    userName: String,
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Hola, $userName",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )

        OutlinedCard(
            shape = CircleShape,

            colors = CardDefaults.outlinedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            GalaIconButton(
                onClick = onNotificationClick,
                icon =
                    GalaIcon.VectorIcon(
                        imgVector = notifications,
                        contentDes = "Notificaciones"
                    )
                ,modifier.size(36.dp)
                
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MostrarHeader() {
    GalaAndroidTheme {
        DashboardHeader(userName = "María")
    }
}