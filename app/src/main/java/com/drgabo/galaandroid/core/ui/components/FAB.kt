package com.drgabo.galaandroid.core.ui.components

import androidx.compose.foundation.shape.CircleShape
import com.drgabo.galaandroid.core.ui.icons.add

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme

@Composable
fun FAB(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(
        modifier = modifier,
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { onClick() },
    ) {
        Icon(add, "Add")
    }
}


@Preview(showBackground = false)
@Composable
fun ShowFAB() {
    GalaAndroidTheme {
        FAB(onClick = {})
    }
}


@Preview(showBackground = false)
@Composable
fun ShowFAB2() {
    FAB(onClick = {}
    )
}
