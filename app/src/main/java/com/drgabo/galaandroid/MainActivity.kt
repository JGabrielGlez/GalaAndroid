package com.drgabo.galaandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.drgabo.galaandroid.navigation.AppHost
import com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme

class MainActivity : ComponentActivity(){
     override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(
            savedInstanceState
        )
        setContent{
            _root_ide_package_.com.drgabo.galaandroid.core.ui.theme.GalaAndroidTheme {
                //no abre una pantalla fija, sino el flujo de navegación completo
                AppHost()
            }
        }
    }
}

@Composable
fun Greetin(name:String){
        Text(text = "oHola mundo $name")
}

@Preview
@Composable
fun PreviewRange(){
    Greetin("Gabriel")
}